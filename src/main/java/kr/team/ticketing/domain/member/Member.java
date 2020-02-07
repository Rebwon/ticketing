package kr.team.ticketing.domain.member;

import kr.team.ticketing.domain.reservation.Reservation;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name = "MEMBERS")
@Entity
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
}
