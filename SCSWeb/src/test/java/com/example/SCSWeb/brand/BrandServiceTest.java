package com.example.SCSWeb.brand;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BrandServiceTest {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandRepository brandRepository;

    @Test
    void getBrandByID() {
        Brand brand = new Brand("Test Brand");
        brandRepository.save(brand);

        Brand testBrand = brandService.getBrandById(brand.getId());

        assert(testBrand.getName()).equals(brand.getName());
        brandRepository.delete(brand);
    }

    @Test
    void exists() {
        Brand brand = new Brand("Test Brand");

        assert(brandService.exists(brand)).equals(false);
        brandRepository.save(brand);
        assert(brandService.exists(brand)).equals(true);
        brandRepository.delete(brand);
    }
}