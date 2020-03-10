package kr.team.ticketing.domain.member;

import kr.team.ticketing.domain.BaseEntity;
import kr.team.ticketing.domain.object.Email;
import lombok.*;

import javax.persistence.*;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    // TODO Spring Security OAuth2 Client 구현.
    @Column
    private Email email;
}
