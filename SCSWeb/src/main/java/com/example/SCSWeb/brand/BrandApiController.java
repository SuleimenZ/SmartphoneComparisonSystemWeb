package com.example.SCSWeb.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/brand")
public class BrandApiController {
    private final BrandService brandService;

    @Autowired
    public BrandApiController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> getBrands(){
        return brandService.getBrands();
    }

    @GetMapping(path = "/{id}")
    public Brand getBrandByID(@PathVariable Long id) {
        return brandService.getBrandById(id);
    }
}
