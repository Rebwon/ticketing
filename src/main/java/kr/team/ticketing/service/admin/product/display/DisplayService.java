package kr.team.ticketing.service.admin.product.display;

import kr.team.ticketing.domain.object.Email;
import kr.team.ticketing.domain.product.display.Address;
import kr.team.ticketing.domain.product.display.Display;
import kr.team.ticketing.domain.product.display.DisplayRepository;
import kr.team.ticketing.web.admin.product.request.DisplayParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DisplayService {
    private final DisplayRepository displayRepository;

    @Transactional
    public Display save(DisplayParam displayParam) {
        Display display = convert(displayParam);
        displayRepository.save(display);
        return display;
    }

    private Display convert(DisplayParam displayParam) {
        return Display.builder()
                .productId(displayParam.getProductId())
                .openingHours(displayParam.getOpeningHours())
                .address(Address.builder()
                        .place(displayParam.getPlace())
                        .placeLot(displayParam.getPlaceLot())
                        .placeStreet(displayParam.getPlaceStreet())
                        .build())
                .homePage(displayParam.getHomePage())
                .tel(displayParam.getTel())
                .email(new Email(displayParam.getEmail()))
                .build();
    }
}
