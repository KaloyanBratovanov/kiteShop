package project.kiteshop.models.service;


import org.springframework.web.multipart.MultipartFile;
import project.kiteshop.models.entities.enums.Type;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductServiceModel {

    private Long id;
    private String name;
    private String imageUrl;
    private MultipartFile imgUrl2;
    private MultipartFile imgUrl3;
    private String videoUrl;
    private String description;
    private BigDecimal price;
    private LocalDate releaseDate;
    private Type type;
    private String brand;
    private String user;

    public ProductServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ProductServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public MultipartFile getImgUrl2() {
        return imgUrl2;
    }

    public ProductServiceModel setImgUrl2(MultipartFile imgUrl2) {
        this.imgUrl2 = imgUrl2;
        return this;
    }

    public MultipartFile getImgUrl3() {
        return imgUrl3;
    }

    public ProductServiceModel setImgUrl3(MultipartFile imgUrl3) {
        this.imgUrl3 = imgUrl3;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public ProductServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public ProductServiceModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Type getType() {
        return type;
    }

    public ProductServiceModel setType(Type type) {
        this.type = type;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ProductServiceModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getUser() {
        return user;
    }

    public ProductServiceModel setUser(String user) {
        this.user = user;
        return this;
    }
}
