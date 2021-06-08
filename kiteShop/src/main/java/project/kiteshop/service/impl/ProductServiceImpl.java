package project.kiteshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.kiteshop.models.entities.BrandEntity;
import project.kiteshop.models.entities.ProductEntity;
import project.kiteshop.models.entities.UserEntity;
import project.kiteshop.models.service.ProductServiceModel;
import project.kiteshop.models.view.ProductCardViewModel;
import project.kiteshop.models.view.ProductVewModel;
import project.kiteshop.repository.ProductRepository;
import project.kiteshop.repository.UserRepository;
import project.kiteshop.service.BrandService;
import project.kiteshop.service.CloudinaryService;
import project.kiteshop.service.ProductService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final BrandService brandService;
    private final CloudinaryService cloudinaryService;

    public ProductServiceImpl(ModelMapper modelMapper, UserRepository userRepository, ProductRepository productRepository, BrandService brandService, CloudinaryService cloudinaryService) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.brandService = brandService;
        this.cloudinaryService = cloudinaryService;
    }


    @Override
    public void createProduct(ProductServiceModel productServiceModel) throws IOException {



        ProductEntity productEntity = modelMapper.map(productServiceModel, ProductEntity.class);

        UserEntity creator =userRepository.findByUsername(productServiceModel.getUser())
                .orElseThrow(() -> new IllegalArgumentException("Creator "+ productServiceModel.getUser()
                        +" could not by found"));

        productEntity.setUserEntity(creator);

        BrandEntity brandEntity = brandService.findByName(productServiceModel.getBrand());

        productEntity.setBrandEntity(brandEntity);

        MultipartFile img2 = productServiceModel.getImgUrl2();

            String imgUrl2 = cloudinaryService.uploadImage(img2);
            productEntity.setImgUrl2(imgUrl2);


        MultipartFile img3 = productServiceModel.getImgUrl3();


            String imgUrl3 = cloudinaryService.uploadImage(img3);
            productEntity.setImgUrl3(imgUrl3);




        productRepository.save(productEntity);
    }

    @Override
    public List<ProductCardViewModel> findAll() {
        return productRepository.findAll()
                .stream().map(productEntity -> {
                    ProductCardViewModel productCardViewModel = modelMapper
                            .map(productEntity, ProductCardViewModel.class);
                    productCardViewModel.setBrand(productEntity.getBrandEntity().getName());
                    return productCardViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public ProductVewModel findById(Long id) {
        return  productRepository.findById(id).
                map(productEntity -> {
                    ProductVewModel productVewModel = modelMapper
                            .map(productEntity, ProductVewModel.class);
                    productVewModel.setBrand(productEntity.getBrandEntity().getName());
                    return productVewModel;

                }).orElseThrow(IllegalArgumentException::new);

    }

    @Override
    public ProductEntity findEntityById(Long productId) {

        return productRepository.findById(productId)
                .orElseThrow(IllegalArgumentException::new);

    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
