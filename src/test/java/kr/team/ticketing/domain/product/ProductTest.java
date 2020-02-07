package kr.team.ticketing.domain.product;

import kr.team.ticketing.domain.common.utils.DateTimeUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
                .name("뮤즈")
                .description("뮤즈 공연입니다.")
                .location("LG 아트센터")
                .startDate(DateTimeUtils.createDateTime("2020-02-07 12:43"))
                .endDate(DateTimeUtils.createDateTime("2020-02-20 12:00"))
                .count(25)
                .build());

        // when
        List<Product> all = productRepository.findAll();

        //then
        Product product = all.get(1);
        assertThat(product.getName()).isEqualTo("뮤즈");
        assertThat(DateTimeUtils.format(product.getStartDate())).isEqualTo("2020-02-07 12:43");
        assertThat(product.getLocation()).isEqualTo("LG 아트센터");
    }

    @Test
    public void categoryValueEqual(){
        Product product = productRepository.findById(1l).get();
        assertThat(product.getCategory().getName()).isEqualTo("뮤지컬");
        assertThat(product.getName()).isEqualTo("헬로 카봇 별나라를 찾아라");
    }
}