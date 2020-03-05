package pl.goreit.sell.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.goreit.api.generated.ProductResponse;
import pl.goreit.sell.domain.model.Product;
import pl.goreit.sell.instrastructure.ProductRepo;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/test")
@Profile("!prod")
public class TestHelperController {

    @Autowired
    private ProductRepo productRepo;


    @GetMapping("/addProduct/")
    @ApiOperation(value = "add 100 products")
    public void addProducts(@RequestParam("amount") Integer amount) {
        long count = 0L;
        for (int i = 0; i < amount; i++) {
            Product product = new Product("Laptop lenovo" + i + count, BigDecimal.valueOf(count + 100));
            productRepo.save(product);
        }


    }
}
