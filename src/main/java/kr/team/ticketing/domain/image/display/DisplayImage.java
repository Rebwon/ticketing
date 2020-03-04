package kr.team.ticketing.domain.image.display;

import kr.team.ticketing.domain.BaseEntity;
import kr.team.ticketing.domain.image.Image;
import kr.team.ticketing.domain.product.display.Display;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DisplayImage extends BaseEntity {
    @ManyToOne
    private Display display;
    @ManyToOne
    private Image image;
}
