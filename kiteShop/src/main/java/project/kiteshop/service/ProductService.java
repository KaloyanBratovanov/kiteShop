package project.kiteshop.service;

import org.springframework.stereotype.Service;
import project.kiteshop.models.entities.ProductEntity;
import project.kiteshop.models.service.ProductServiceModel;
import project.kiteshop.models.view.ProductCardViewModel;
import project.kiteshop.models.view.ProductVewModel;

import java.io.IOException;
import java.util.List;

public interface ProductService {


    void createProduct(ProductServiceModel productServiceModel) throws IOException;

    List<ProductCardViewModel> findAll();

    ProductVewModel findById(Long id);

    ProductEntity findEntityById(Long productId);

    void deleteById(Long id);
}
