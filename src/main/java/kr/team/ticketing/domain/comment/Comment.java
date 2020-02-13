package kr.team.ticketing.domain.comment;

import kr.team.ticketing.domain.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION_MEMBER_COMMENTS")
@Getter
@EqualsAndHashCode(of = "id", callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {
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

    @Column(name = "MEMBER_COMMENT")
    private String comment;

    @Builder
    public Comment(double score, String comment) {
        this.score = score;
        this.comment = comment;
    }
}
