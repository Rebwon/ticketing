package kr.team.ticketing.domain.member;

import kr.team.ticketing.domain.common.Email;
import kr.team.ticketing.domain.reservation.Reservation;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name = "MEMBERS")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @Embedded
    private Email email;

    private String tel;
    private String picture;

    @OneToMany
    private List<Reservation> reservationList = new ArrayList<>();

    @Builder
    public Member(String name, Email email, String tel, String picture) {
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.picture = picture;
    }
}
