package org.berberovic.maya.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MayaRecipesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MayaRecipesApplication.class, args);
    }
}
