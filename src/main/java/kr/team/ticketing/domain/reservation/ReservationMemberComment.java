package kr.team.ticketing.domain.reservation;

import kr.team.ticketing.domain.common.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION_MEMBER_COMMENT")
@Getter
public class ReservationMemberComment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_MEMBER_COMMENT_ID")
    private Long id;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "RESERVATION_MEMBER_ID")
    private Long reservationMemberId;

    @Column(name = "SCORE")
    private int score;

    @Column(name = "COMMENT")
    private String comment;
}
