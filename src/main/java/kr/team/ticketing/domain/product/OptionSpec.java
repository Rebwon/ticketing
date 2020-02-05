package kr.team.ticketing.domain.product;

import kr.team.ticketing.domain.generic.money.Money;
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
    private Money price;
}
