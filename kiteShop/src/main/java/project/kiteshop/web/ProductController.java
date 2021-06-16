package project.kiteshop.web;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.kiteshop.models.binding.ProductAddBindingModel;
import project.kiteshop.models.binding.ProductUpdateBindingModel;
import project.kiteshop.models.service.ProductServiceModel;
import project.kiteshop.models.view.ProductVewModel;
import project.kiteshop.service.BrandService;
import project.kiteshop.service.ProductService;

import javax.validation.Valid;
import java.io.IOException;
import java.time.ZoneId;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ModelMapper modelMapper;
    private final ProductService productService;
    private final BrandService brandService;

    public ProductController(ModelMapper modelMapper, ProductService productService, BrandService brandService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
        this.brandService = brandService;
    }

    @ModelAttribute("productAddBindingModel")
    public ProductAddBindingModel createProductAddBindingModel() {
        return new ProductAddBindingModel();
    }

    @GetMapping("/add")
    public String addProducts(Model model){

        model.addAttribute("brands", brandService.findAllBrands());

        return "add-product";
    }


    @PostMapping("/add")
    public String addAlbum(@Valid ProductAddBindingModel productAddBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetails principal) throws IOException {

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);
            return "redirect:add";
        }

        ProductServiceModel productServiceModel = modelMapper.map(
                productAddBindingModel,
                ProductServiceModel.class);

        productServiceModel.setUser(principal.getUsername());

        productServiceModel.setReleaseDate(productAddBindingModel
                .getReleaseDate().atStartOfDay(ZoneId.systemDefault()).toLocalDate());

        productService.createProduct(productServiceModel);

        return "redirect:/home";
    }




    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        productService.deleteById(id);

        return "redirect:/home";
    }


    @ModelAttribute("productUpdateBindingModel")
    public ProductUpdateBindingModel createProductUpdateBindingModel() {
        return new ProductUpdateBindingModel();
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model){

        ProductUpdateBindingModel productUpdateBindingModel = productService.findByIdBindingModel(id);

        model.addAttribute("productUpdateBindingModel", productUpdateBindingModel);
        model.addAttribute("brands", productUpdateBindingModel.getBrand());

        return "update";
    }

//    @PostMapping("/update/{id}")
//    public String updateConfirm(@PathVariable Long id){
//        System.out.println();
//        return "redirect:/home";
//    }

    @PostMapping("/update/{id}")
    public String updateConfirm (@Valid ProductUpdateBindingModel productUpdateBindingModel,
                                 @PathVariable Long id,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetails principal) throws IOException {

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productUpdateBindingModel", productUpdateBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.productUpdateBindingModel", bindingResult);
            return "redirect:update";
        }

        ProductServiceModel productServiceModel = modelMapper.map(
                productUpdateBindingModel,
                ProductServiceModel.class);

        productServiceModel.setUser(principal.getUsername());

        productServiceModel.setReleaseDate(productUpdateBindingModel
                .getReleaseDate().atStartOfDay(ZoneId.systemDefault()).toLocalDate());


        productService.updateProduct(productServiceModel);

        return "redirect:/home";
    }


}
