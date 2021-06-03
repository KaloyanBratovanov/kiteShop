package project.kiteshop.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
public class LogEntity extends BaseEntity{

    @ManyToOne
    private UserEntity userEntity;
    @ManyToOne
    private ProductEntity productEntity;
    @Column(name = "action", nullable = false)
    private String action;
    @Column(name = "date_time", nullable = false)
    private LocalDateTime localDateTime;

    public LogEntity() {
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public LogEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public LogEntity setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
        return this;
    }

    public String getAction() {
        return action;
    }

    public LogEntity setAction(String action) {
        this.action = action;
        return this;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public LogEntity setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }
}
