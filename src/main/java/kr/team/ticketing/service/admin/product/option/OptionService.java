package kr.team.ticketing.service.admin.product.option;

import kr.team.ticketing.domain.object.generic.money.Money;
import kr.team.ticketing.domain.object.generic.money.Ratio;
import kr.team.ticketing.domain.product.Product;
import kr.team.ticketing.domain.product.ProductRepository;
import kr.team.ticketing.domain.product.detail.Option;
import kr.team.ticketing.domain.product.detail.OptionRepository;
import kr.team.ticketing.domain.product.detail.ProductType;
import kr.team.ticketing.web.admin.product.request.OptionParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OptionService {
    private final OptionRepository optionRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Option save(Long productId, OptionParam param) {
        Product product = productRepository.getOne(productId);
        Option option = Option.builder()
                .productType(ProductType.valueOf(param.getProductType()))
                .discountRate(Ratio.valueOf(param.getDiscountRate()))
                .price(Money.wons(param.getPrice()))
                .build();
        option.setProduct(product);
        optionRepository.save(option);
        return option;
    }
}
