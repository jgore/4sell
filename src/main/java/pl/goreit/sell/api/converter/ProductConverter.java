package pl.goreit.sell.api.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.goreit.api.generated.ProductResponse;
import pl.goreit.sell.domain.model.Product;

@Component
public class ProductConverter implements Converter<Product, ProductResponse> {

    @Override
    public ProductResponse convert(Product product) {
        return new ProductResponse(product.getCategoryName(), product.getName(), product.getPrice().toString());
    }
}
