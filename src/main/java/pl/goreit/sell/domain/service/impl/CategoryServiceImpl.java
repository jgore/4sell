package pl.goreit.sell.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import pl.goreit.api.generated.CategoryResponse;
import pl.goreit.sell.domain.DomainException;
import pl.goreit.sell.domain.ExceptionCode;
import pl.goreit.sell.domain.model.Category;
import pl.goreit.sell.domain.service.CategoryService;
import pl.goreit.sell.instrastructure.mongo.CategoryRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final ConversionService sellConversionService;

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(ConversionService sellConversionService, CategoryRepo categoryRepo) {
        this.sellConversionService = sellConversionService;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public CategoryResponse findByNameWithDetails(String name) throws DomainException {
        Category category = categoryRepo.findByName(name)
                .orElseThrow(() -> new DomainException(ExceptionCode.FOR_SELL_01));

        List<Category> subCategofies = categoryRepo.findByParentCategoryName(name);

        CategoryResponse categoryResponse = sellConversionService.convert(category, CategoryResponse.class);
        categoryResponse.withCategories(subCategofies.stream().
                map(subCategory -> sellConversionService.convert(subCategory, CategoryResponse.class))
                .collect(Collectors.toList()));

        return categoryResponse;

    }

    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepo.findAll().stream()
                .map(category -> sellConversionService.convert(category, CategoryResponse.class))
                .collect(Collectors.toList());
    }
}
