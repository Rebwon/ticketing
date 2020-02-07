package kr.team.ticketing.domain.reservation;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationOption {
    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private int price;

    public ReservationOption(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
