package kr.team.ticketing.domain.image;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository<T extends Image> extends JpaRepository<T, Long> {
}
