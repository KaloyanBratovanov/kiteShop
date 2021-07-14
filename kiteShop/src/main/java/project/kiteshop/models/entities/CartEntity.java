package project.kiteshop.models.entities;

import project.kiteshop.models.entities.enums.Type;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "carts")
public class CartEntity extends BaseEntity{

    @Column(nullable = false)
    private String imageUrl;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToOne
    private BrandEntity brandEntity;
    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    private UserEntity userEntity;

    public CartEntity() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CartEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public CartEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Type getType() {
        return type;
    }

    public CartEntity setType(Type type) {
        this.type = type;
        return this;
    }

    public BrandEntity getBrandEntity() {
        return brandEntity;
    }

    public CartEntity setBrandEntity(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CartEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public CartEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

}
