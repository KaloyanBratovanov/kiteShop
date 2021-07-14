package project.kiteshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import project.kiteshop.models.view.CartVewModel;
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
    public String cart(Model model, Principal principal){

        model.addAttribute("products", cartService.findAllProductsInMyCart(principal));

        List<CartVewModel> cartVewModels = cartService.findAllProductsInMyCart(principal);
        BigDecimal totalSum = new BigDecimal("0") ;

        for (CartVewModel cartVewModel : cartVewModels) {
            totalSum = totalSum.add(cartVewModel.getPrice());
        }
        model.addAttribute("totalSum", totalSum);

        return "cart";
    }

    @GetMapping("/buy/{id}")
    public String buyById(@PathVariable Long id){
        cartService.buyById(id);

        return "redirect:/";
    }

    @GetMapping("/buy/all")
    public String buyAll(){
        cartService.buyAll();
        return "redirect:/";
    }

}
