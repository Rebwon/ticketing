package kr.team.ticketing.domain;

import kr.team.ticketing.config.JpaConfig;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManager;

@Disabled
@DataJpaTest
@Import(JpaConfig.class)
public class DomainTests {
    @Autowired
    protected EntityManager em;
}
