package kr.team.ticketing.domain.image;

import kr.team.ticketing.domain.BaseEntity;
import kr.team.ticketing.domain.image.display.DisplayImage;
import kr.team.ticketing.domain.image.product.ProductImage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Where(clause = "deleted = 0")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image extends BaseEntity {
    @Column
    private String imgName;
    @Column
    private String saveImgName;
    @Column
    private String contentType;
    @Column
    private int deleted;
    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> productImages = new ArrayList<>();
    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DisplayImage> displayImages = new ArrayList<>();
}
