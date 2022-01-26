package com.example.SCSWeb.chipset;

import com.example.SCSWeb.os.OS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(path="/chipset")
public class ChipsetController {
    private final ChipsetService chipsetService;

    @Autowired
    public ChipsetController(ChipsetService chipsetService) {
        this.chipsetService = chipsetService;
    }

    @GetMapping
    String getChipset(Model model){
        model.addAttribute("chipsetList", chipsetService.getChipsets());
        return "chipset/chipsetList";
    }

    @GetMapping(path = "/{id}")
    String getChipsets(Model model, @PathVariable Long id){
        model.addAttribute("id", id);
        if(!chipsetService.existsById(id)){ return "chipset/chipsetNotFound"; }

        Chipset chipset = chipsetService.getChipsetById(id);
        model.addAttribute("chipset", chipset);
        return "chipset/chipset";
    }
}
