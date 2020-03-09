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
    private int deleted = 0;
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservationLineItem> lineItems = new ArrayList<>();

    @Builder
    public Reservation(Long memberId, String name, Email email, String tel, LocalDateTime reserveDate) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.reserveDate = reserveDate;
    }

    public void addLineItem(ReservationLineItem lineItem) {
        lineItem.setReservation(this);
        this.lineItems.add(lineItem);
    }

    public void addLineItems(List<ReservationLineItem> lineItems) {
        lineItems.forEach(i -> addLineItem(i));
    }

    public void delete() {
        this.deleted = 1;
    }
}
