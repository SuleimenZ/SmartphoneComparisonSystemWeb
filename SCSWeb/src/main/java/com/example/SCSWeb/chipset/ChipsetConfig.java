package com.example.SCSWeb.chipset;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChipsetConfig {

    @Bean
    CommandLineRunner chipsetCommandLineRunner(ChipsetRepository repository){
        return args -> {
            Chipset appleA15Bionic = new Chipset(
                    "Apple A15 Bionic"
            );
            Chipset exynos2100 = new Chipset(
                    "Exynos 2100"
            );
            Chipset snapdragon765G = new Chipset(
                    "Snapdragon 765G 5G"
            );

            repository.saveAll(
                    List.of(appleA15Bionic,
                            exynos2100,
                            snapdragon765G));
        };
    }
}
