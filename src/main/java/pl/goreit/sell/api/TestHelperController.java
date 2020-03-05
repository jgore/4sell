package pl.goreit.sell.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.goreit.sell.domain.CategoryName;
import pl.goreit.sell.domain.model.Category;
import pl.goreit.sell.domain.model.Product;
import pl.goreit.sell.instrastructure.mongo.CategoryRepo;
import pl.goreit.sell.instrastructure.mongo.ProductRepo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/test")
@Profile("!prod")
public class TestHelperController {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    @GetMapping("/addProduct/")
    @ApiOperation(value = "add 100 products")
    public void addProducts(@RequestParam("amount") Integer amount) {
        for (int count = 0; count < amount; count++) {
            Product product = new Product("Laptop lenovo" + count, BigDecimal.valueOf(count + 100));
            productRepo.save(product);
        }
    }

    @GetMapping("/addCategories/")
    @ApiOperation(value = "add ALL categories")
    public void addCategories() {

        long amount = 10;
        List<CategoryName> categoryNames = Arrays.asList(CategoryName.values());

        categoryNames.forEach(categoryName -> {
            createMainCategoryWithSubs(amount, categoryName.name());
        });
    }

    private void createMainCategoryWithSubs(long amount, String mainCategoryName) {
        List<Category> subCategories = new ArrayList<>();
        for (int count = 0; count < amount; count++) {
            Category category = new Category("pod_categoria_" + count, new ArrayList<>());
            subCategories.add(category);
        }

        Category mainCategory = new Category(mainCategoryName, subCategories);

        categoryRepo.save(mainCategory);
    }
}
