package mysuperapp;

import controllers.SkyScannerRedirectController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class)
@ComponentScan(basePackageClasses = SkyScannerRedirectController.class)
@EnableJpaRepositories("mysuperapp")
public class Application {
    public static void main (String[] args){
        SpringApplication.run(Application.class, args);
    }
}
