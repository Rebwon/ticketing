package kr.team.ticketing.service.admin.product.option;

import kr.team.ticketing.domain.product.detail.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OptionService {
    private final OptionRepository optionRepository;
}
