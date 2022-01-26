package com.example.SCSWeb.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/brand")
public class BrandController {
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    String getBrands(Model model){
        model.addAttribute("brandList",brandService.getBrands());
        return "brand/brandList";
    }

    @GetMapping(path = "/{id}")
    String getBrandByID(Model model,@PathVariable Long id) {
        model.addAttribute("id", id);
        if(!brandService.existsById(id)){ return "brand/brandNotFound"; }

        Brand brand = brandService.getBrandById(id);
        model.addAttribute("brand", brand);
        return "brand/brand";
    }
}
