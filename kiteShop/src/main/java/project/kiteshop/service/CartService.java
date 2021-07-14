package project.kiteshop.service;

import project.kiteshop.models.view.CartVewModel;

import java.security.Principal;
import java.util.List;

public interface CartService {

    void createProductInCart(Long id, Principal principal);


    List<CartVewModel> findAllProductsInMyCart(Principal principal);


    void buyById(Long id);

    void buyAll();
}
