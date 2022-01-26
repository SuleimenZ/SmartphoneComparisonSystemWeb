package com.example.SCSWeb.chipset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/chipset")
public class ChipsetApiController {
    private final ChipsetService chipsetService;

    @Autowired
    public ChipsetApiController(ChipsetService chipsetService) {
        this.chipsetService = chipsetService;
    }

    @GetMapping
    public List<Chipset> getChipsets(){
        return chipsetService.getChipsets();
    }

    @GetMapping(path = "/{id}")
    public Chipset getChipset(@PathVariable Long id){
        return chipsetService.getChipsetById(id);
    }

}
