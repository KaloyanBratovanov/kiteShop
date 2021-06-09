package project.kiteshop.models.view;

import org.springframework.web.multipart.MultipartFile;
import project.kiteshop.models.entities.enums.Type;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductVewModel {

    private Long id;
    private String name;
    private String imageUrl;
    private String imgUrl2;
    private String imgUrl3;
    private String videoUrl;
    private String description;
    private BigDecimal price;
    private LocalDate releaseDate;
    private Type type;
    private String brand;

    public ProductVewModel() {
    }

    public Long getId() {
        return id;
    }

    public ProductVewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductVewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductVewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }


    public String getImgUrl2() {
        return imgUrl2;
    }

    public ProductVewModel setImgUrl2(String imgUrl2) {
        this.imgUrl2 = imgUrl2;
        return this;
    }

    public String getImgUrl3() {
        return imgUrl3;
    }

    public ProductVewModel setImgUrl3(String imgUrl3) {
        this.imgUrl3 = imgUrl3;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public ProductVewModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductVewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductVewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public ProductVewModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Type getType() {
        return type;
    }

    public ProductVewModel setType(Type type) {
        this.type = type;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ProductVewModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}
