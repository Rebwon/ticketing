package kr.team.ticketing.domain.reservation;

import kr.team.ticketing.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {
    @Column
    private Long productId;
    @Column
    private Long reservationId;
    @Column
    private double score;
    @Lob
    private String comment;
}
