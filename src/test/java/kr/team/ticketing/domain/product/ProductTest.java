package kr.team.ticketing.domain.product;

import kr.team.ticketing.domain.common.utils.DateTimeUtils;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static kr.team.ticketing.domain.product.OptionGroupSpec.OptionGroupDetail.AGE;
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
                .category(new Category("뮤지컬"))
                .name("뮤즈")
                .description("뮤즈 공연입니다.")
                .location("LG 아트센터")
                .startDate(DateTimeUtils.createDateTime("2020-02-07 12:43"))
                .endDate(DateTimeUtils.createDateTime("2020-02-20 12:00"))
                .count(25)
                .optionGroupSpecs(Arrays.asList(
                        OptionGroupSpec.builder()
                            .detail(AGE)
                            .options(Arrays.asList(
                                new OptionSpec("성인", 15000),
                                new OptionSpec("청소년", 13500),
                                new OptionSpec("7세이상", 11000)))
                            .build()))
                .build());

        // when
        List<Product> all = productRepository.findAll();

        //then
        Product product = all.get(2);
        assertThat(product.getName()).isEqualTo("뮤즈");
        assertThat(DateTimeUtils.format(product.getStartDate())).isEqualTo("2020-02-07 12:43");
        assertThat(product.getLocation()).isEqualTo("LG 아트센터");
        assertThat(product.getCategory().getName()).isEqualTo("뮤지컬");

        assertThat(product.getOptionGroupSpecs().get(0).getDetail()).isEqualTo(AGE);
    }

    @Ignore
    @Test
    public void findAllCategory(){
        List<Product> musical = productRepository.findAllByCategory(new Category("뮤지컬"));
        System.out.println(musical);
    }
}