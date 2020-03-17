package kr.team.ticketing.domain.object.generic.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RatioTest {
    @DisplayName("할인율 확인")
    @Test
    void testDiscountRate() {
        Ratio ratio = Ratio.valueOf(0.2);

        assertThat(ratio.getRate()).isEqualTo(0.2);
    }
}