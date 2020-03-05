package pl.goreit.sell.instrastructure.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.goreit.sell.domain.model.Category;

@Repository
public interface CategoryRepo extends MongoRepository<Category, String> {
    Category findByName(String name);
}
