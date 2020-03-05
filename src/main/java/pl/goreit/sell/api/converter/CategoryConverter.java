package pl.goreit.sell.api.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.goreit.api.generated.CategoryResponse;
import pl.goreit.sell.domain.model.Category;

import java.util.stream.Collectors;

@Component
public class CategoryConverter implements Converter<Category, CategoryResponse> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryResponse convert(Category source) {
        return new CategoryResponse(source.getName(), source.getCategories().stream()
                .map(category -> conversionService.convert(category, CategoryResponse.class))
                .collect(Collectors.toList()));
    }
}
