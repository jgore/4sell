package pl.goreit.sell.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.goreit.api.generated.ProductResponse;
import pl.goreit.sell.domain.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @ApiOperation(value = "pobiera wszystkie produkty", notes = "pobiera wszystkie produkty")
    public List<ProductResponse> getProducts() {
        return productService.getAll();
    }
}
