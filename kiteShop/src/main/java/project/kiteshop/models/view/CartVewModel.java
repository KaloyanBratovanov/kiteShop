package project.kiteshop.models.view;

import project.kiteshop.models.entities.enums.Type;

import java.math.BigDecimal;

public class CartVewModel {

    private Long id;
    private String imageUrl;
    private String name;
    private Type type;
    private BigDecimal price;
    private String brand;

    public CartVewModel() {
    }

    public Long getId() {
        return id;
    }

    public CartVewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CartVewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public CartVewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Type getType() {
        return type;
    }

    public CartVewModel setType(Type type) {
        this.type = type;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CartVewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CartVewModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}
