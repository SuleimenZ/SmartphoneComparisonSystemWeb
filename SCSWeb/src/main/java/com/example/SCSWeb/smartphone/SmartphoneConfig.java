package com.example.SCSWeb.smartphone;

import com.example.SCSWeb.brand.Brand;
import com.example.SCSWeb.brand.BrandRepository;
import com.example.SCSWeb.chipset.ChipsetRepository;
import com.example.SCSWeb.os.OSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Configuration
public class SmartphoneConfig {
    private final OSRepository osRepository;
    private final ChipsetRepository chipsetRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public SmartphoneConfig(OSRepository osRepository, ChipsetRepository chipsetRepository, BrandRepository brandRepository) {
        this.osRepository = osRepository;
        this.chipsetRepository = chipsetRepository;
        this.brandRepository = brandRepository;
    }

    @Bean
    CommandLineRunner smartphoneCommandLineRunner(SmartphoneRepository repository){
        return args -> {
            Smartphone iPhone13 = new Smartphone(
                    "iPhone 13",
                    brandRepository.findAll().stream().filter(
                            b -> b.getName().equals("Apple"))
                            .findFirst().orElse(null),
                    LocalDate.parse("2021-09-14"),
                    osRepository.findAll().stream().filter(
                            o -> o.getName().equals("iOS"))
                            .filter(o -> o.getVersion().equals("15"))
                            .findFirst().orElse(null),
                    174.0,
                    1170,
                    2532,
                    146.7,
                    71.5,
                    7.7,
                    512,
                    4,
                    chipsetRepository.findAll().stream().filter(
                            c -> c.getName().equals("Apple A15 Bionic"))
                            .findFirst().orElse(null),
                    "Blue",
                    3240
            );

            Smartphone pixel5a5G = new Smartphone(
                    "Pixel 5a 5G",
                    brandRepository.findAll().stream().filter(
                                    b -> b.getName().equals("Google"))
                            .findFirst().orElse(null),
                    LocalDate.parse("2021-08-17"),
                    osRepository.findAll().stream().filter(
                                    o -> o.getName().equals("Android"))
                            .filter(o -> o.getVersion().equals("11"))
                            .findFirst().orElse(null),
                    183.0,
                    1080,
                    2400,
                    154.9,
                    73.7,
                    7.6,
                    128,
                    6,
                    chipsetRepository.findAll().stream().filter(
                                    c -> c.getName().equals("Snapdragon 765G 5G"))
                            .findFirst().orElse(null),
                    "Black",
                    4680
            );

            Smartphone galaxyS215G = new Smartphone(
                    "Galaxy S21 5G",
                    brandRepository.findAll().stream().filter(
                                    b -> b.getName().equals("Samsung"))
                            .findFirst().orElse(null),
                    LocalDate.parse("2021-01-14"),
                    osRepository.findAll().stream().filter(
                                    o -> o.getName().equals("Android"))
                            .filter(o -> o.getVersion().equals("11"))
                            .findFirst().orElse(null),
                    169.0,
                    1080,
                    2400,
                    151.7,
                    71.2,
                    7.9,
                    256,
                    8,
                    chipsetRepository.findAll().stream().filter(
                                    c -> c.getName().equals("Exynos 2100"))
                            .findFirst().orElse(null),
                    "Phantom White",
                    4000
            );

            repository.saveAll(List.of(
                    iPhone13,
                    pixel5a5G,
                    galaxyS215G));
        };
    }
}
