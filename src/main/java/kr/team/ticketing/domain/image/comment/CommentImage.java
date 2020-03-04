package kr.team.ticketing.domain.image.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.team.ticketing.domain.BaseEntity;
import kr.team.ticketing.domain.image.Image;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentImage extends BaseEntity {
    @JsonIgnore
    @ManyToOne
    private Image image;
    @Column
    private Long reservationId;
    @Column
    private Long displayId;
}
