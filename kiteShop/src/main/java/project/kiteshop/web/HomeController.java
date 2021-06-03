package project.kiteshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.kiteshop.service.CarouselService;
import project.kiteshop.service.ProductService;

@Controller
public class HomeController {

    private final CarouselService carouselService;
    private final ProductService productService;

    public HomeController(CarouselService carouselService, ProductService productService) {
        this.carouselService = carouselService;
        this.productService = productService;
    }


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model){

        model.addAttribute("firstImg", carouselService.firstImage());
        model.addAttribute("secondImg", carouselService.secondImage());
        model.addAttribute("thirdImg", carouselService.thirdImage());

        model.addAttribute("allProducts", productService.findAll());

        return "/home";
    }
}
