package pl.goreit.sell.instrastructure.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.goreit.sell.domain.model.Product;

@Repository
public interface ProductRepo extends MongoRepository<Product, String> {
}
