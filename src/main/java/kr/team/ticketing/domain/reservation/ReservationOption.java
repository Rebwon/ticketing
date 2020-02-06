package kr.team.ticketing.domain.reservation;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
public class ReservationOption {
    @Column(name = "PRICE")
    private int price;
}
