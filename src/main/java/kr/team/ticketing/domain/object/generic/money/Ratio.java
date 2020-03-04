package kr.team.ticketing.domain.object.generic.money;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ratio {
    private double rate;

    public static Ratio valueOf(double rate){
        return new Ratio(rate);
    }

    Ratio(double rate){
        this.rate = rate;
    }

    private Money getDiscountPrice(){
        return new Money(BigDecimal.valueOf(rate));
    }

    public Money of(Money price) {
        if(rate < 1){
            Money discount = price.times(rate);
            return price.minus(discount);
        } else{
            Money discountPrice = getDiscountPrice();
            return price.minus(discountPrice);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ratio ratio = (Ratio) o;
        return Double.compare(ratio.rate, rate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }
}
