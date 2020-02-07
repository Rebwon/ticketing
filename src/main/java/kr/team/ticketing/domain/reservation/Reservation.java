package kr.team.ticketing.domain.reservation;

import kr.team.ticketing.domain.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESERVATIONS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "RESERVATION_ID")
    private List<ReservationInfo> reservationInfoList = new ArrayList<>();
}
