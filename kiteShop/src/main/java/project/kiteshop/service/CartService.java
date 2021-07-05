package project.kiteshop.service;

import project.kiteshop.models.view.ProductVewModel;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public interface CartService {

    void createProductInCart(Long id, Principal principal);


    List<ProductVewModel> findAllProductsInMyCart(Principal principal);

    BigDecimal findTotalSum();
}
