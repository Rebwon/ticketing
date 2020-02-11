package kr.team.ticketing.domain.product;

import kr.team.ticketing.domain.generic.money.Money;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OPTION_SPECS")
@Getter
public class OptionSpec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_SPEC_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Money price;

    @Builder
    public OptionSpec(Long id, String name, Money price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OptionSpec that = (OptionSpec) o;
        return price == that.price &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
