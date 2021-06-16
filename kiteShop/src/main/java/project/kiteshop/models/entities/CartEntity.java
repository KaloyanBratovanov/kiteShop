package project.kiteshop.models.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class CartEntity extends BaseEntity{


    @ManyToOne
    private UserEntity userEntity;
    @ManyToOne
    private ProductEntity productEntity;

    public CartEntity() {
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public CartEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public CartEntity setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
        return this;
    }
}
