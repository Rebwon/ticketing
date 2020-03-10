package kr.team.ticketing.service.admin.product.display;

import kr.team.ticketing.domain.product.display.DisplayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DisplayService {
    private final DisplayRepository displayRepository;
}
