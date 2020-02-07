package kr.team.ticketing.domain.member;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Email {

    @javax.validation.constraints.Email
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String value;
}
