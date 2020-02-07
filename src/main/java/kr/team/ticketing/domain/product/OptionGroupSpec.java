package kr.team.ticketing.domain.product;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "OPTION_GROUP_SPECS")
@Getter
public class OptionGroupSpec {
    public enum OptionGroupDetail{AGE,GRADE,PACKAGE}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_GROUP_SPEC_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "DETAILS")
    private OptionGroupDetail detail;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "OPTION_GROUP_SPEC_ID")
    private List<OptionSpec> optionSpecs = new ArrayList<>();
}
