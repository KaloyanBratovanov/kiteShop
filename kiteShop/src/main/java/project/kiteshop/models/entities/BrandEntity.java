package project.kiteshop.models.entities;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    @Expose
    @Column(nullable = false)
    private String name;
    @Expose
    @Column(nullable = false, columnDefinition = "TEXT")
    private String brandInformation;

    public BrandEntity() {
    }

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrandInformation() {
        return brandInformation;
    }

    public BrandEntity setBrandInformation(String brandInformation) {
        this.brandInformation = brandInformation;
        return this;
    }
}
