package kr.team.ticketing.domain.image.product;

import kr.team.ticketing.domain.BaseEntity;
import kr.team.ticketing.domain.image.Image;
import kr.team.ticketing.domain.image.ImageType;
import kr.team.ticketing.domain.product.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductImage extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column
    private ImageType imageType;
    @ManyToOne
    private Image image;
    @ManyToOne
    private Product product;
}
