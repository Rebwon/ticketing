package kr.team.ticketing.domain.generic.money;


import org.junit.Test;

import java.math.BigDecimal;

public class MoneyTest {
    @Test
    public void sum(){
        Money money = new Money(new BigDecimal(13000));
    }
}