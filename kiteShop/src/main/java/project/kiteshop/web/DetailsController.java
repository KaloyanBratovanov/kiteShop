package project.kiteshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.kiteshop.models.view.ProductVewModel;
import project.kiteshop.service.CartService;
import project.kiteshop.service.ProductService;

import java.security.Principal;

@Controller
@RequestMapping("/details")
public class DetailsController {


    private final ProductService productService;
    private final CartService cartService;

    public DetailsController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }


    @GetMapping("/{id}")
    public String details(@PathVariable Long id, Model model){

        ProductVewModel productVewModel = productService.findById(id);

        model.addAttribute("product", productVewModel);
        return "details";
    }


    @PostMapping("/put/{id}")
    public String putThisInMyCart(@PathVariable Long id, Principal principal){

        cartService.createProductInCart(id, principal);

        return "redirect:/home";
    }
}
