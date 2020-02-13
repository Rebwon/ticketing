package kr.team.ticketing.domain.coupon;

import kr.team.ticketing.domain.common.BaseTimeEntity;
import kr.team.ticketing.domain.generic.money.Ratio;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COUPONS")
@Getter
@EqualsAndHashCode(of = "id", callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon extends BaseTimeEntity {
    public enum CouponStatus{USE,USED,EXPIRED}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUPON_ID")
    private Long id;

    private String name;

    @Column(name = "DISCOUNT")
    private Ratio discount;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "COUPON_STATUS")
    private CouponStatus couponStatus = CouponStatus.USE;

    @Column(name = "EXPIRATION_DATE")
    private LocalDateTime expirationDate;

    @Builder
    public Coupon(String name, Ratio discount, LocalDateTime expirationDate) {
        this.name = name;
        this.discount = discount;
        this.expirationDate = expirationDate;
    }

    public void isUsed() {
        this.couponStatus = CouponStatus.USED;
    }

    public void isExpired(){
        this.couponStatus = CouponStatus.EXPIRED;
    }
}
