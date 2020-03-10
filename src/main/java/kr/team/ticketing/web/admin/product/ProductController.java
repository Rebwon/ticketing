package kr.team.ticketing.web.admin.product;

import kr.team.ticketing.domain.product.Product;
import kr.team.ticketing.service.admin.product.ProductService;
import kr.team.ticketing.service.admin.product.display.DisplayService;
import kr.team.ticketing.service.admin.product.option.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/admin/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final OptionService optionService;
    private final DisplayService displayService;

    @PostMapping
    public ResponseEntity saveProduct(@RequestBody Product product) {
        Product save = productService.save(product);
        URI uri = linkTo(ProductController.class).slash(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @PutMapping("/{productId}")
    public ResponseEntity updateProduct(@PathVariable Long productId,
                                        @RequestBody Product product) {
        Product update = productService.update(productId, product);
        return ResponseEntity.ok(update);
    }

    @GetMapping
    public ResponseEntity findProducts(Pageable pageable) {
        Page<Product> products = productService.find(pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity findProduct(@PathVariable Long productId) {
        Product product = productService.find(productId);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Long productId) {
        productService.delete(productId);
        return ResponseEntity.noContent().build();
    }
}
