package kr.team.ticketing.domain.reservation;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESERVATION_LINE_ITEMS")
@Getter
public class ReservationLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_LINE_ITEM_ID")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "PRODUCT_COUNT")
    private int count;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESERVATION_LINE_ITEM_ID")
    private List<ReservationOptionGroup> groups = new ArrayList<>();
}
