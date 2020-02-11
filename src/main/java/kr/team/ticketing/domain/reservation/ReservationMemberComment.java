package kr.team.ticketing.domain.reservation;

import kr.team.ticketing.domain.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION_MEMBER_COMMENT")
@Getter
@EqualsAndHashCode(of = "id", callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationMemberComment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_MEMBER_COMMENT_ID")
    private Long id;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "RESERVATION_ID")
    private Long reservationId;

    @Column(name = "SCORE")
    private double score;

    @Column(name = "COMMENT")
    private String comment;

    @Builder
    public ReservationMemberComment(double score, String comment) {
        this.score = score;
        this.comment = comment;
    }
}
