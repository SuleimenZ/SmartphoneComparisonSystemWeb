package com.example.SCSWeb.os;

import com.example.SCSWeb.smartphone.SmartphoneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OSConfig {

    @Bean
    CommandLineRunner osCommandLineRunner(OSRepository repository){
        return args -> {
            OS android11 = new OS(
                    "Android",
                    "11"
            );
            OS android12 = new OS(
                    "Android",
                    "12"
            );

            OS iOS15 = new OS(
                    "iOS",
                    "15"
            );

            OS iOS14 = new OS(
                    "iOS",
                    "14"
            );

            repository.saveAll(List.of(
                    android11,
                    android12,
                    iOS14,
                    iOS15
            ));
        };
    }
}
