package project.kiteshop.service;

import java.security.Principal;

public interface CartService {
    void createProductInCart(Long id, Principal principal);
}
