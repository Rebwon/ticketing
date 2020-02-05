package kr.team.ticketing.domain.reservation;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESERVATIONS")
@Getter
public class Reservation {
    public enum ReservationStatus{PAYED, CANCELD, SCHEDULED};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "RESERVATION_MEMBER_NAME")
    private String reservationMemberName;

    @Column(name = "RESERVATION_MEMBER_EMAIL")
    private String email;

    @Column(name = "RESERVATION_MEMBER_TEL")
    private String tel;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private ReservationStatus reservationStatus;

    @Column(name = "RESERVATION_DATE")
    private LocalDateTime reservationDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESERVATION_ID")
    private List<ReservationLineItem> reservationLineItems = new ArrayList<>();
}
