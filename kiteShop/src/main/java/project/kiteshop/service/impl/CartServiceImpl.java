package project.kiteshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.kiteshop.models.entities.CartEntity;
import project.kiteshop.models.entities.UserEntity;
import project.kiteshop.models.view.ProductVewModel;
import project.kiteshop.repository.CartRepository;
import project.kiteshop.service.CartService;
import project.kiteshop.service.ProductService;
import project.kiteshop.service.UserService;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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

        cartEntity.setProductEntity(productService.findProductEntityById(id));
        cartEntity.setUserEntity(userEntity);

        cartRepository.save(cartEntity);
    }

    @Override
    public List<ProductVewModel> findAllProductsInMyCart(Principal principal) {

        UserEntity userEntity = userService
                .findByName(principal.getName());

        List<CartEntity> cartEntities = cartRepository.findAllByUserEntityId(userEntity.getId());

        List<ProductVewModel> productVewModels = new ArrayList<>();

        for (CartEntity cartEntity : cartEntities) {

            ProductVewModel productVewModel = productService.findById(cartEntity.getProductEntity().getId());

            productVewModels.add(productVewModel);
        }



        return productVewModels;

    }
}
