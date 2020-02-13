package kr.team.ticketing.domain.coupon;

import kr.team.ticketing.config.JpaConfig;
import kr.team.ticketing.domain.common.utils.DateTimeUtils;
import kr.team.ticketing.domain.generic.money.Ratio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static kr.team.ticketing.domain.coupon.Coupon.CouponStatus.EXPIRED;
import static kr.team.ticketing.domain.coupon.Coupon.CouponStatus.USED;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(JpaConfig.class)
public class CouponTest {
    @Autowired
    CouponRepository couponRepository;

    @Test
    public void create() {
        // given
        couponRepository.save(Coupon.builder()
                .name("2달간 20% 특가 할인 쿠폰!")
                .discount(Ratio.valueOf(0.2))
                .expirationDate(DateTimeUtils.createDateTime("2020-04-02 10:20"))
                .build());

        // when
        List<Coupon> all = couponRepository.findAll();
        Coupon coupon = all.get(0);

        // then
        assertThat(coupon.getDiscount().getRate()).isEqualTo(0.2);
        assertThat(coupon.getExpirationDate().getYear()).isEqualTo(2020);
        assertThat(coupon.getExpirationDate().getMonth().getValue()).isEqualTo(4);
    }

    @Test
    public void isUsedCoupon() {
        // given
        Coupon notUsed = Coupon.builder()
                .name("2달간 20% 특가 할인 쿠폰!")
                .discount(Ratio.valueOf(0.2))
                .expirationDate(DateTimeUtils.createDateTime("2020-04-02 12:00"))
                .build();

        notUsed.isUsed();
        couponRepository.save(notUsed);

        // when
        List<Coupon> all = couponRepository.findAll();
        Coupon used = all.get(0);

        // then
        assertThat(used.getCouponStatus()).isEqualTo(USED);
    }

    @Test
    public void isExpiredCoupon() {
        // given
        Coupon notUsed = Coupon.builder()
                .name("2달간 20% 특가 할인 쿠폰!")
                .discount(Ratio.valueOf(0.2))
                .expirationDate(DateTimeUtils.createDateTime("2020-04-02 12:00"))
                .build();

        notUsed.isExpired();
        couponRepository.save(notUsed);

        // when
        List<Coupon> all = couponRepository.findAll();
        Coupon used = all.get(0);

        // then
        assertThat(used.getCouponStatus()).isEqualTo(EXPIRED);
    }
}