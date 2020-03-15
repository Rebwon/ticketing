package kr.team.ticketing.domain.product.detail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.team.ticketing.domain.BaseEntity;
import kr.team.ticketing.domain.object.generic.money.Money;
import kr.team.ticketing.domain.object.generic.money.Ratio;
import kr.team.ticketing.domain.product.Product;
import kr.team.ticketing.web.admin.product.request.OptionParam;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "OPTIONS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Option extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column
    private ProductType productType;
    @Column
    private Money price;
    @Column
    private Ratio discountRate;
    @JsonIgnore
    @ManyToOne
    private Product product;

    @Builder
    public Option(ProductType productType, Money price, Ratio discountRate) {
        this.productType = productType;
        this.price = price;
        this.discountRate = discountRate;
    }

    public void setProduct(Product product) {
        if(this.product != null) {
            this.product.getOptions().remove(this);
        }
        this.product = product;
    }

    public void update(OptionParam param) {
        this.productType = ProductType.valueOf(param.getProductType());
        this.price = Money.wons(param.getPrice());
        this.discountRate = Ratio.valueOf(param.getDiscountRate());
    }
}
