package kr.team.ticketing.domain.member;

import kr.team.ticketing.domain.common.Email;
import kr.team.ticketing.domain.coupon.Coupon;
import kr.team.ticketing.domain.reservation.Reservation;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name = "MEMBERS")
@Entity
@EqualsAndHashCode(of = "id")
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

    @OneToMany
    private List<Coupon> couponList = new ArrayList<>();

    @Builder
    public Member(String name, Email email, String tel, String picture) {
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.picture = picture;
    }
}
