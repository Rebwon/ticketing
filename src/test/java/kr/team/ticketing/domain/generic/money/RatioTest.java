package kr.team.ticketing.domain.generic.money;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RatioTest {
    @Test
    public void discount() {
        Ratio twentyPercent = Ratio.valueOf(0.2);
        Ratio twentyFivePercent = Ratio.valueOf(0.25);
        Ratio discountPrice = Ratio.valueOf(3000);
        Money price = Money.wons(15000);

        assertThat(twentyPercent.of(price).toString()).isEqualTo("12000원");
        assertThat(twentyFivePercent.of(price).toString()).isEqualTo("11250원");
        assertThat(discountPrice.of(price).toString()).isEqualTo("12000원");
    }
}
