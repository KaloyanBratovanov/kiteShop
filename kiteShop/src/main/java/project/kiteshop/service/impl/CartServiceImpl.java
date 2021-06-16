package project.kiteshop.service.impl;

import org.springframework.stereotype.Service;
import project.kiteshop.models.entities.CartEntity;
import project.kiteshop.models.entities.UserEntity;
import project.kiteshop.repository.CartRepository;
import project.kiteshop.service.CartService;
import project.kiteshop.service.ProductService;
import project.kiteshop.service.UserService;

import java.security.Principal;

@Service
public class CartServiceImpl implements CartService {

   private final CartRepository cartRepository;
   private final ProductService productService;
   private final UserService userService;

    public CartServiceImpl(CartRepository cartRepository, ProductService productService, UserService userService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.userService = userService;
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
}
