package project.kiteshop.service;

import org.springframework.data.jpa.repository.Query;
import project.kiteshop.models.entities.BrandEntity;

import java.util.List;

public interface BrandService {

    void seedBrands();

    BrandEntity findByName(String brand);


    List<String> findAllBrands();
}
