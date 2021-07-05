package project.kiteshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.kiteshop.service.CartService;

import java.security.Principal;

@Controller
@RequestMapping("/carts")
public class CartController {


    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping
    public String stats(Model model, Principal principal){

        model.addAttribute("products", cartService.findAllProductsInMyCart(principal));
        model.addAttribute("totalSum", cartService.findTotalSum());
        return "cart";
    }

}
