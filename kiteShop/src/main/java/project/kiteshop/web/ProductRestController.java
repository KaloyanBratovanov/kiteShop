package project.kiteshop.web;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.kiteshop.models.view.ProductCardViewModel;
import project.kiteshop.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("/products")
@RestController
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductRestController(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api")
    public ResponseEntity<List<ProductCardViewModel>> findAll() {

        List<ProductCardViewModel> productCardViewModels = productRepository.findAll().stream()
                .map(productEntity -> {
                    ProductCardViewModel productCardViewModel = modelMapper.map(productEntity, ProductCardViewModel.class);
                    productCardViewModel.setBrand(productEntity.getBrandEntity().getName());
                    return productCardViewModel;
                })
                .collect(Collectors.toList());


        return ResponseEntity
                .ok()
                .body(productCardViewModels);
    }

}
