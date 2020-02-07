package kr.team.ticketing.domain.reservation;

import kr.team.ticketing.domain.common.Email;
import kr.team.ticketing.domain.common.utils.DateTimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static kr.team.ticketing.domain.reservation.ReservationOptionGroup.ReservationOptionGroupDetail.AGE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReservationTest {
    @Autowired
    ReservationRepository reservationRepository;

    @Test
    public void insert(){
        // given
        reservationRepository.save(Reservation.builder()
                .name("김철수")
                .email(new Email("chulsu@naver.com"))
                .reservationDate(DateTimeUtils.createDateTime("2020-02-07 16:45"))
                .reservationStatus(ReservationStatus.BEFORE)
                .reservationInfoList(Arrays.asList(ReservationInfo.builder()
                        .name("뮤즈")
                        .count(3)
                        .groups(Arrays.asList(
                                ReservationOptionGroup.builder()
                                        .detail(AGE)
                                        .options(Arrays.asList(
                                                new ReservationOption("성인", 15000),
                                                new ReservationOption("청소년", 13500)
                                        ))
                                        .build()
                        ))
                        .build()))
                .build());

        // when
        List<Reservation> all = reservationRepository.findAll();

        // then
        Reservation reservation = all.get(0);
        assertThat(reservation.getEmail().getId()).isEqualTo("chulsu");
        assertThat(reservation.getName()).isEqualTo("김철수");

        ReservationInfo reservationInfo = reservation.getReservationInfoList().get(0);
        assertThat(reservationInfo.getCount()).isEqualTo(3);
        assertThat(reservationInfo.getName()).isEqualTo("뮤즈");

        ReservationOptionGroup reservationOptionGroup = reservationInfo.getGroups().get(0);
        assertThat(reservationOptionGroup.getDetail()).isEqualTo(AGE);
        assertThat(reservationOptionGroup.getReservationOptions().size()).isEqualTo(2);
    }
}