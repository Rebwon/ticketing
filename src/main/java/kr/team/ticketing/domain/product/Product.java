package kr.team.ticketing.domain.product;

import kr.team.ticketing.domain.BaseEntity;
import kr.team.ticketing.domain.image.product.ProductImage;
import kr.team.ticketing.domain.product.detail.Option;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {
    @Column
    private String description;
    @Lob
    private String content;
    @Column
    private String event;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options = new ArrayList<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> productImages = new ArrayList<>();
}
