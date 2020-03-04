package kr.team.ticketing.domain.product.display;

import kr.team.ticketing.domain.BaseEntity;
import kr.team.ticketing.domain.image.display.DisplayImage;
import kr.team.ticketing.domain.object.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Display extends BaseEntity {
    @Column
    private String openingHours;
    @Embedded
    private Address address;
    @Column
    private String tel;
    @Column
    private String homePage;
    @Column
    private Email email;
    @OneToMany(mappedBy = "display", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DisplayImage> displayImages = new ArrayList<>();
}
