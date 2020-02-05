package kr.team.ticketing.domain.reservation;

import kr.team.ticketing.domain.generic.money.Money;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
public class ReservationOption {
    @Column(name = "PRICE")
    private Money price;
}
