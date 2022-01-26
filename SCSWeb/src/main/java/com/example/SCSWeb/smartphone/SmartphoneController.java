package com.example.SCSWeb.smartphone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/smartphone")
public class SmartphoneController {

    private final SmartphoneService smartphoneService;
    @Autowired
    public SmartphoneController(SmartphoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

    @GetMapping
    String getSmartphones(Model model){
        model.addAttribute("smartphoneList", smartphoneService.getSmartphones());
        return "smartphone/smartphoneList";
    }

    @GetMapping(path="/{id}")
    String getSmartphoneById(Model model, @PathVariable Long id){
        model.addAttribute("id", id);
        if(!smartphoneService.existsById(id)){ return "smartphone/smartphoneNotFound"; }

        Smartphone smartphone = smartphoneService.getSmartphoneById(id);
        model.addAttribute("smartphone", smartphone);
        return "smartphone/smartphone";
    }
}
