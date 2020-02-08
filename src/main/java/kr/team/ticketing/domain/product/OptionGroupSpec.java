package kr.team.ticketing.domain.product;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "OPTION_GROUP_SPECS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OptionGroupSpec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_GROUP_SPEC_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "DETAIL")
    private OptionGroupDetail detail;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "OPTION_GROUP_SPEC_ID")
    private List<OptionSpec> optionSpecs = new ArrayList<>();

    @Builder
    public OptionGroupSpec(OptionGroupDetail detail, List<OptionSpec> options) {
        this.detail = detail;
        this.optionSpecs.addAll(options);
    }
}
