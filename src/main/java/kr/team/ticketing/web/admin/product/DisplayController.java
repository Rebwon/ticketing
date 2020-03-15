package kr.team.ticketing.web.admin.product;

import kr.team.ticketing.domain.product.display.Display;
import kr.team.ticketing.service.admin.product.display.DisplayService;
import kr.team.ticketing.web.admin.product.request.DisplayParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/admin/v1/displays")
@RequiredArgsConstructor
public class DisplayController {
    private final DisplayService displayService;

    @PostMapping
    public ResponseEntity saveDisplay(@RequestBody DisplayParam displayParam) {
        Display display = displayService.save(displayParam);
        URI uri = linkTo(DisplayController.class).slash(display.getId()).toUri();
        return ResponseEntity.created(uri).body(display);
    }
}
