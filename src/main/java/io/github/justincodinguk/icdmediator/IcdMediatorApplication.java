package io.github.justincodinguk.icdmediator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class IcdMediatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcdMediatorApplication.class, args);
    }

}
