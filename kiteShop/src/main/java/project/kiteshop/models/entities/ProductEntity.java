package project.kiteshop.models.entities;

import org.springframework.format.annotation.DateTimeFormat;
import project.kiteshop.models.entities.enums.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="products")
public class ProductEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String imageUrl;
    @Column
    private String imgUrl2;
    @Column
    private String imgUrl3;
    @Column
    private String videoUrl;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToOne
    private BrandEntity brandEntity;
    @ManyToOne
    private UserEntity userEntity;
    @OneToMany(mappedBy = "productEntity",targetEntity = LogEntity.class,  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LogEntity> logs;


    // TODO: 7/14/2021
//    @OneToMany(mappedBy = "productEntity",targetEntity = CartEntity.class,  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<CartEntity> cartEntities;

    public ProductEntity() {
    }

    public String getName() {
        return name;
    }

    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public ProductEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getImgUrl2() {
        return imgUrl2;
    }

    public ProductEntity setImgUrl2(String imgUrl2) {
        this.imgUrl2 = imgUrl2;
        return this;
    }

    public String getImgUrl3() {
        return imgUrl3;
    }

    public ProductEntity setImgUrl3(String imgUrl3) {
        this.imgUrl3 = imgUrl3;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public ProductEntity setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public ProductEntity setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Type getType() {
        return type;
    }

    public ProductEntity setType(Type type) {
        this.type = type;
        return this;
    }

    public BrandEntity getBrandEntity() {
        return brandEntity;
    }

    public ProductEntity setBrandEntity(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public ProductEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public Set<LogEntity> getLogs() {
        return logs;
    }

    public ProductEntity setLogs(Set<LogEntity> logs) {
        this.logs = logs;
        return this;
    }


}
