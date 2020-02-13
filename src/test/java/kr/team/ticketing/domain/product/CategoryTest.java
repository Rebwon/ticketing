package kr.team.ticketing.domain.product;

import kr.team.ticketing.domain.generic.money.Money;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static kr.team.ticketing.domain.product.OptionGroupDetail.AGE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryTest {
    @Autowired
    ProductRepository productRepository;

    @Before
    public void setUp() {
        // given
        IntStream.range(0, 20).forEach(this::saveProduct);
    }

    @After
    public void cleanUp() {
        productRepository.deleteAll();
    }

    private Product saveProduct(int index) {
        Product product = Product.builder()
                .category(new Category("뮤지컬"))
                .count(15)
                .name("test content" + index)
                .optionGroupSpecs(asList(
                        OptionGroupSpec.builder()
                                .detail(AGE)
                                .options(asList(
                                        OptionSpec.builder().name("성인").price(Money.wons(15000)).build(),
                                        OptionSpec.builder().name("청소년").price(Money.wons(13500)).build(),
                                        OptionSpec.builder().name("7세 이상").price(Money.wons(12000)).build()
                                ))
                                .build()
                ))
                .build();
        return productRepository.save(product);
    }

    @Test
    public void findAllCategoryName() {
        List<Product> musical = productRepository.findAllByCategoryName("뮤지컬");
        assertThat(musical.size()).isEqualTo(20);
    }
}
