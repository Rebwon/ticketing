package kr.team.ticketing.domain.generic.money;

import java.math.BigDecimal;

public class Money {
    private final BigDecimal amount;

    Money(BigDecimal amount) {
        this.amount = amount;
    }
}
