package pl.goreit.sell.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Product {

    @Id
    private String id;
    private String categoryName;
    private String name;
    private BigDecimal price;
    private Status status = Status.AVAILABLE;

    private LocalDateTime creationDate;

    public Product(String categoryName, String name, BigDecimal price) {
        this.categoryName = categoryName;
        this.name = name;
        this.price = price;

    }

    public String getId() {
        return id;
    }

    public void assigntoCategory(String categoryId) {
        this.categoryName = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getPrice(), product.getPrice()) &&
                status == product.status &&
                Objects.equals(creationDate, product.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getPrice(), status, creationDate);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", creationDate=" + creationDate +
                '}';
    }

    public enum Status {
        AVAILABLE, SOLD, ARCHIVED
    }
}
