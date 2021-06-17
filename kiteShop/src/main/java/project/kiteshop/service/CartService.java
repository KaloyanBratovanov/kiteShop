package project.kiteshop.service;

import project.kiteshop.models.view.ProductCardViewModel;
import project.kiteshop.models.view.ProductVewModel;

import java.security.Principal;
import java.util.List;

public interface CartService {

    void createProductInCart(Long id, Principal principal);


    List<ProductVewModel> findAllProductsInMyCart(Principal principal);
}
