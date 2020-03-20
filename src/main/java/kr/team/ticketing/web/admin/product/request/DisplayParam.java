package kr.team.ticketing.web.admin.product.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DisplayParam {
    private Long productId;
    private String openingHours;
    private String place;
    private String placeLot;
    private String placeStreet;
    private String tel;
    private String homePage;
    private String email;

    @Builder
    public DisplayParam(Long productId, String openingHours, String place, String placeLot, String placeStreet, String tel, String homePage, String email) {
        this.productId = productId;
        this.openingHours = openingHours;
        this.place = place;
        this.placeLot = placeLot;
        this.placeStreet = placeStreet;
        this.tel = tel;
        this.homePage = homePage;
        this.email = email;
    }
}
