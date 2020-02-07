package kr.team.ticketing.domain.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "OPTION_SPECS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OptionSpec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_SPEC_ID")
    private Long id;

    @Column(name = "PRICE")
    private int price;
}
