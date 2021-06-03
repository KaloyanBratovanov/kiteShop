package project.kiteshop;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.kiteshop.service.BrandService;
import project.kiteshop.service.UserService;

@Component
public class KiteDBApplicationInit implements CommandLineRunner {

    private final UserService userService;
    private final BrandService brandService;

    public KiteDBApplicationInit(UserService userService, BrandService brandService) {
        this.userService = userService;
        this.brandService = brandService;
    }

    @Override
    public void run(String... args) throws Exception {

        userService.seedUsers();
        brandService.seedBrands();
    }
}
