package com.example.SCSWeb.brand;

import com.example.SCSWeb.smartphone.SmartphoneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BrandConfig {

    @Bean
    CommandLineRunner brandCommandLineRunner(BrandRepository repository){
        return args -> {
            Brand apple = new Brand(
                    "Apple"
            );
            Brand samsung = new Brand(
                    "Samsung"
            );
            Brand google = new Brand(
                    "Google"
            );
            repository.saveAll(
                    List.of(apple,
                            samsung,
                            google));
        };
    }
}
