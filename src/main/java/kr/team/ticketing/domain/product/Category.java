package kr.team.ticketing.domain.product;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long id;

    @Column(name = "CATEGORY_NAME")
    private String name;
}
