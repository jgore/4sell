package pl.goreit.sell.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import pl.goreit.api.generated.CategoryResponse;
import pl.goreit.sell.domain.service.CategoryService;
import pl.goreit.sell.instrastructure.mongo.CategoryRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Optional<CategoryResponse> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepo.findAll().stream()
                .map(category -> conversionService.convert(category, CategoryResponse.class))
                .collect(Collectors.toList());
    }
}
