package pl.goreit.sell.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import pl.goreit.api.generated.ProductResponse;
import pl.goreit.sell.domain.service.ProductService;
import pl.goreit.sell.instrastructure.mongo.ProductRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ConversionService sellConversionService;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<ProductResponse> getAll() {
        return productRepo.findAll().stream()
                .map(product -> sellConversionService.convert(product, ProductResponse.class))
                .collect(Collectors.toList());
    }
}
