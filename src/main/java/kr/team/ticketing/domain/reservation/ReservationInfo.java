package kr.team.ticketing.domain.reservation;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESERVATION_INFO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class ReservationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_INFO_ID")
    private Long id;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "RESERVATION_INFO_NAME")
    private String name;

    @Column(name = "RESERVATION_INFO_COUNT")
    private int count;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESERVATION_INFO_ID")
    private List<ReservationOptionGroup> groups = new ArrayList<>();

    @Builder
    public ReservationInfo(String name, int count, List<ReservationOptionGroup> groups) {
        this.name = name;
        this.count = count;
        this.groups.addAll(groups);
    }
}
