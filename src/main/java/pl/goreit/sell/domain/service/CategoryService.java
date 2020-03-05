package pl.goreit.sell.domain.service;

import pl.goreit.api.generated.CategoryResponse;
import pl.goreit.sell.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<CategoryResponse> findByName(String name);

    List<CategoryResponse> findAll();
}
