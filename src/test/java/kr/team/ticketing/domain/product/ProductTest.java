package kr.team.ticketing.domain.product;

import kr.team.ticketing.domain.common.utils.DateTimeUtils;
import kr.team.ticketing.domain.generic.money.Money;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static kr.team.ticketing.domain.product.OptionGroupDetail.AGE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductTest {
    @Autowired
    ProductRepository productRepository;

    @After
    public void cleanUp(){
        productRepository.deleteAll();
    }

    @Test
    public void insert(){
        // given
        productRepository.save(Product.builder()
                .category(new Category("공연"))
                .name("뮤즈")
                .description("뮤즈 공연입니다.")
                .location("LG 아트센터")
                .startDate(DateTimeUtils.createDateTime("2020-02-07 12:43"))
                .endDate(DateTimeUtils.createDateTime("2020-02-20 12:00"))
                .count(25)
                .optionGroupSpecs(asList(
                        OptionGroupSpec.builder()
                            .detail(AGE)
                            .options(asList(
                                OptionSpec.builder().name("성인").price(Money.wons(15000)).build(),
                                OptionSpec.builder().name("청소년").price(Money.wons(13500)).build(),
                                OptionSpec.builder().name("7세 이상").price(Money.wons(12000)).build()))
                            .build()))
                .build());

        // when
        List<Product> all = productRepository.findAll();

        //then
        Product product = all.get(0);
        assertThat(product.getName()).isEqualTo("뮤즈");
        assertThat(DateTimeUtils.format(product.getStartDate())).isEqualTo("2020-02-07 12:43");
        assertThat(product.getLocation()).isEqualTo("LG 아트센터");
        assertThat(product.getCategory().getName()).isEqualTo("공연");

        OptionGroupSpec groupSpec = product.getOptionGroupSpecs().get(0);
        assertThat(groupSpec.getDetail()).isEqualTo(AGE);
        assertThat(groupSpec.getOptionSpecs().get(0).getName()).isEqualTo("성인");
    }
}