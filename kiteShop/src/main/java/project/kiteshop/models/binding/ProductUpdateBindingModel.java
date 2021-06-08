package project.kiteshop.models.binding;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import project.kiteshop.models.entities.enums.Type;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductUpdateBindingModel {

    private Long id;
    @Size(min = 3, max = 20)
    private String name;
    @Size(min = 5)
    private String imageUrl;
    private MultipartFile imgUrl2;
    private MultipartFile imgUrl3;
    private String videoUrl;
    @Size(min = 5)
    private String description;
    @DecimalMin(value = "0")
    private BigDecimal price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @NotNull
    private Type type;
    @NotNull
    private String brand;


    public ProductUpdateBindingModel() {
    }


    public Long getId() {
        return id;
    }

    public ProductUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductUpdateBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ProductUpdateBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public MultipartFile getImgUrl2() {
        return imgUrl2;
    }

    public ProductUpdateBindingModel setImgUrl2(MultipartFile imgUrl2) {
        this.imgUrl2 = imgUrl2;
        return this;
    }

    public MultipartFile getImgUrl3() {
        return imgUrl3;
    }

    public ProductUpdateBindingModel setImgUrl3(MultipartFile imgUrl3) {
        this.imgUrl3 = imgUrl3;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public ProductUpdateBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductUpdateBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductUpdateBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public ProductUpdateBindingModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Type getType() {
        return type;
    }

    public ProductUpdateBindingModel setType(Type type) {
        this.type = type;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ProductUpdateBindingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }
}
