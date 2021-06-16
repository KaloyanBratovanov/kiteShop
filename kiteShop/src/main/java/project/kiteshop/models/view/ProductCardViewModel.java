package project.kiteshop.models.view;

import org.springframework.web.multipart.MultipartFile;
import project.kiteshop.models.entities.enums.Type;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductCardViewModel {

    private Long id;
    private String name;
    private String imageUrl;
    private String description;
    private BigDecimal price;
    private LocalDate releaseDate;
    private Type type;
    private String brand;

    public ProductCardViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ProductCardViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductCardViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductCardViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductCardViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductCardViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public ProductCardViewModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Type getType() {
        return type;
    }

    public ProductCardViewModel setType(Type type) {
        this.type = type;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ProductCardViewModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}
