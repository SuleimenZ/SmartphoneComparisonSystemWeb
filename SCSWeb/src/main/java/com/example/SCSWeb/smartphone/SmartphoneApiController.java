package com.example.SCSWeb.smartphone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/smartphone")
public class SmartphoneApiController {

    private final SmartphoneService smartphoneService;

    @Autowired
    public SmartphoneApiController(SmartphoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

    @GetMapping
    public List<Smartphone> getSmartphones() {
        return smartphoneService.getSmartphones();
    }

    @GetMapping(path = "/{id}")
    public Smartphone getSmartphoneById(@PathVariable Long id) {
        return smartphoneService.getSmartphoneById(id);
    }
}
