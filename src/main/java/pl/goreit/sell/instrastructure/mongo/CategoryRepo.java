package pl.goreit.sell.instrastructure.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.goreit.sell.domain.model.Category;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends MongoRepository<Category, String> {
    Optional<Category> findByName(String name);

    List<Category> findByParentCategoryName(String parent);
}
