package project.kiteshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class KiteShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(KiteShopApplication.class, args);
    }

}
