package kr.team.ticketing.domain.common.utils;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class DateTimeUtilsTest {
    @Test
    public void createDateTime(){
        LocalDateTime dateTime = DateTimeUtils.createDateTime("2020-02-07 12:22");
        assertThat(dateTime.getYear()).isEqualTo(2020);
        assertThat(dateTime.getMonthValue()).isEqualTo(2);
        assertThat(dateTime.getDayOfMonth()).isEqualTo(7);
        assertThat(dateTime.getHour()).isEqualTo(12);
        assertThat(dateTime.getMinute()).isEqualTo(22);
    }
}