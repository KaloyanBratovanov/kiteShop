package project.kiteshop;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.kiteshop.service.BrandService;
import project.kiteshop.service.DayLogService;
import project.kiteshop.service.UserService;

@Component
public class KiteDBApplicationInit implements CommandLineRunner {

    private final UserService userService;
    private final BrandService brandService;
    private final DayLogService dayLogService;

    public KiteDBApplicationInit(UserService userService, BrandService brandService, DayLogService dayLogService) {
        this.userService = userService;
        this.brandService = brandService;
        this.dayLogService = dayLogService;
    }

    @Override
    public void run(String... args) throws Exception {

        userService.seedUsers();
        brandService.seedBrands();
        dayLogService.seedDayLog();
    }
}
