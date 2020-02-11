package kr.team.ticketing.domain.reservation;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RESERVATION_OPTION_GROUPS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class ReservationOptionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RESERVATION_OPTION_GROUP_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "DETAIL")
    private ReservationOptionGroupDetail detail;

    @ElementCollection
    @CollectionTable(name = "RESERVATION_OPTIONS",
            joinColumns = @JoinColumn(name = "RESERVATION_OPTION_GROUP_ID"))
    private List<ReservationOption> reservationOptions;

    @Builder
    public ReservationOptionGroup(ReservationOptionGroupDetail detail, List<ReservationOption> options) {
        this.detail = detail;
        this.reservationOptions = options;
    }
}
