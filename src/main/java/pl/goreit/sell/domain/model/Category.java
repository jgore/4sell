package pl.goreit.sell.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Category {

    @Id
    private String id;

    private String parentCategoryName;

    private String name;

    public Category(String parentCategoryName, String name) {
        this.parentCategoryName = parentCategoryName;
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(getId(), category.getId()) &&
                Objects.equals(getParentCategoryName(), category.getParentCategoryName()) &&
                Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getParentCategoryName(), getName());
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
