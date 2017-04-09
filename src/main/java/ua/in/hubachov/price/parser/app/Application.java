package ua.in.hubachov.price.parser.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import ua.in.hubachov.price.web.controller.ExternalBotController;

/**
 * Created by Sashko on 4/7/17.
 */
@SpringBootApplication
@ComponentScan("ua.in.hubachov")
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class, ExternalBotController.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
