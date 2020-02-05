package kr.team.ticketing.domain.reservation;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RESERVATION_OPTION_GROUPS")
@Getter
public class ReservationOptionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RESERVATION_OPTION_GROUP_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ElementCollection
    @CollectionTable(name = "RESERVATION_OPTIONS",
            joinColumns = @JoinColumn(name = "RESERVATION_OPTION_GROUP_ID"))
    private List<ReservationOption> reservationOptions;
}
