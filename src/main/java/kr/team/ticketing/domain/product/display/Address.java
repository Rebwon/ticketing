package kr.team.ticketing.domain.product.display;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor
public class Address {
    @Column
    private String place;        // 장소
    @Column
    private String placeLot;      // 지번주소
    @Column
    private String placeStreet;   // 도로명주소

    @Builder
    public Address(String place, String placeLot, String placeStreet) {
        this.place = place;
        this.placeLot = placeLot;
        this.placeStreet = placeStreet;
    }
}
