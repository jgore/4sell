package pl.goreit.sell.domain.service;

import pl.goreit.api.generated.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAll();
}
