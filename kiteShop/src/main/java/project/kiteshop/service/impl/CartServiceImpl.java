package project.kiteshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.kiteshop.models.entities.CartEntity;
import project.kiteshop.models.entities.ProductEntity;
import project.kiteshop.models.entities.UserEntity;
import project.kiteshop.models.view.CartVewModel;
import project.kiteshop.models.view.ProductVewModel;
import project.kiteshop.repository.CartRepository;
import project.kiteshop.service.CartService;
import project.kiteshop.service.ProductService;
import project.kiteshop.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {


   private final CartRepository cartRepository;
   private final ProductService productService;
   private final UserService userService;
   private final ModelMapper modelMapper;


    public CartServiceImpl(CartRepository cartRepository, ProductService productService, UserService userService, ModelMapper modelMapper) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void createProductInCart(Long id, Principal principal) {

        CartEntity cartEntity = new CartEntity();

        UserEntity userEntity = userService
                .findByName(principal.getName());

        ProductEntity productEntity = new ProductEntity();

        productEntity = productService.findProductEntityById(id);

        cartEntity.setImageUrl(productEntity.getImageUrl());
        cartEntity.setName(productEntity.getName());
        cartEntity.setPrice(productEntity.getPrice());
        cartEntity.setType(productEntity.getType());
        cartEntity.setUserEntity(userEntity);
        cartEntity.setBrandEntity(productEntity.getBrandEntity());


        cartRepository.save(cartEntity);
    }

    @Override
    public List<CartVewModel> findAllProductsInMyCart(Principal principal) {

        UserEntity userEntity = userService
                .findByName(principal.getName());

        return cartRepository.findAllByUserEntityId(userEntity.getId())
                .stream().map(cartEntity -> {
                    CartVewModel cartVewModel = modelMapper.map(cartEntity, CartVewModel.class);
                    cartVewModel.setBrand(cartEntity.getBrandEntity().getName());
                    return cartVewModel;
                }).collect(Collectors.toList());


    }

    @Override
    public void buyById(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        cartRepository.deleteAll();
    }
}
