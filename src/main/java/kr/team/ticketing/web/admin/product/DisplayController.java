package kr.team.ticketing.web.admin.product;

import kr.team.ticketing.domain.product.display.Display;
import kr.team.ticketing.service.admin.product.display.DisplayService;
import kr.team.ticketing.web.admin.product.request.DisplayParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{displayId}")
    public ResponseEntity updateDisplay(@PathVariable Long displayId,
                                        @RequestBody DisplayParam displayParam) {
        displayService.update(displayId, displayParam);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity findDisplays(Pageable pageable) {
        Page<Display> displays = displayService.find(pageable);
        return ResponseEntity.ok(displays);
    }

    @GetMapping("/{displayId}")
    public ResponseEntity findDisplay(@PathVariable Long displayId) {
        Display display = displayService.find(displayId);
        return ResponseEntity.ok(display);
    }

    @DeleteMapping("/{displayId}")
    public ResponseEntity deleteDisplay(@PathVariable Long displayId) {
        displayService.delete(displayId);
        return ResponseEntity.noContent().build();
    }
}
