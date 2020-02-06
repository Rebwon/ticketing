package kr.team.ticketing.domain.product;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "OPTION_SPECS")
@Getter
public class OptionSpec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_SPEC_ID")
    private Long id;

    @Column(name = "PRICE")
    private int price;
}
