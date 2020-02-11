package kr.team.ticketing.domain.generic.money;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RatioTest {
    @Test
    public void discount() {
        Ratio ratio1 = Ratio.valueOf(0.2);
        Ratio ratio2 = Ratio.valueOf(0.25);
        Ratio ratio3 = Ratio.valueOf(0.1);
        Money price = Money.wons(15000);

        assertThat(ratio1.of(price).toString()).isEqualTo("12000원");
        assertThat(ratio2.of(price).toString()).isEqualTo("11250원");
        assertThat(ratio3.of(price).toString()).isEqualTo("13500원");
    }
}
