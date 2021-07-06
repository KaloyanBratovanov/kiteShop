package project.kiteshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.kiteshop.models.view.ProductVewModel;
import project.kiteshop.service.CartService;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

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

        List<ProductVewModel> productVewModelList = cartService.findAllProductsInMyCart(principal);
        BigDecimal totalSum = new BigDecimal("0") ;

        for (ProductVewModel productVewModel : productVewModelList) {
            totalSum = totalSum.add(productVewModel.getPrice());
        }
        model.addAttribute("totalSum", totalSum);

        return "cart";
    }

}
