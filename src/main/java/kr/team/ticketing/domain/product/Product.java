package kr.team.ticketing.domain.product;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String description;

    @Column(name = "PRODUCT_COUNT")
    private int count;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "LOCATION")
    private String location;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID")
    private List<OptionGroupSpec> optionGroupSpecs = new ArrayList<>();

    @Builder
    public Product(Category category, String name, String description, int count, LocalDateTime startDate, LocalDateTime endDate, String location, List<OptionGroupSpec> optionGroupSpecs) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.count = count;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.optionGroupSpecs.addAll(optionGroupSpecs);
    }
}
