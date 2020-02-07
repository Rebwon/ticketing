package kr.team.ticketing.domain.reservation;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESERVATION_INFO")
@Getter
public class ReservationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_INFO_ID")
    private Long id;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "CONTENT_NAME")
    private String name;

    @Column(name = "CONTENT_COUNT")
    private int count;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESERVATION_INFO_ID")
    private List<ReservationOptionGroup> groups = new ArrayList<>();
}
