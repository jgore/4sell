package pl.goreit.sell.domain.service;

import pl.goreit.api.generated.CategoryResponse;
import pl.goreit.sell.domain.DomainException;

import java.util.List;

public interface CategoryService {
    CategoryResponse findByNameWithDetails(String name) throws DomainException;

    List<CategoryResponse> findAll();
}
