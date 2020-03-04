package kr.team.ticketing.domain.reservation;

import kr.team.ticketing.domain.BaseEntity;
import kr.team.ticketing.domain.object.Email;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Where(clause = "deleted = 0")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation extends BaseEntity {
    @Column
    private Long memberId;
    @Column
    private String name;
    @Column
    private Email email;
    @Column
    private String tel;
    @Column
    private LocalDateTime reserveDate;
    @Column
    private int deleted;
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservationLineItem> lineItems = new ArrayList<>();
}
