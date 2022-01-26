package com.example.SCSWeb.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getBrands(){
        return brandRepository.findAll();
    }

    public Brand getBrandById(Long id) { return brandRepository.findById(id).orElse(null); }

    public Boolean exists(Brand brand) {return brandRepository.exists(Example.of(brand));}

    public Boolean existsById(Long id) { return brandRepository.existsById(id);}
}
