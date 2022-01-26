package com.example.SCSWeb.index;

import com.example.SCSWeb.smartphone.Smartphone;
import com.example.SCSWeb.smartphone.SmartphoneRepository;
import com.example.SCSWeb.smartphone.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(path="/")
public class IndexController {
    private final SmartphoneService smartphoneService;
    private List<Smartphone> selectedSmartphones = new ArrayList<>();

    @Autowired
    public IndexController(SmartphoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

    @GetMapping
    String getIndex(Model model){
        List<Smartphone> selectedSmartphones = new ArrayList<>();
        model.addAttribute("smartphoneList", smartphoneService.getSmartphones());
        model.addAttribute("selectedSmartphones", selectedSmartphones);
        return "index";
    }

    @GetMapping(path = "/compare")
    String getComparison(Model model){
        model.addAttribute("selectedSmartphones", selectedSmartphones);
        return "compare";
    }

    @PostMapping(path="/compare/add")
    String AddSmartphoneToCompareList(@RequestParam(value="phone", required = false) Long phone,
                                      Model model){
        if(phone == null) { return "index"; }
        Smartphone smartphone = smartphoneService.getSmartphoneById(phone);
        if(selectedSmartphones.stream().anyMatch(s -> s.getName().equals(smartphone.getName()))) { return "index"; }

        selectedSmartphones.add(smartphone);
        return "index";
    }

    @PostMapping(path="/compare/remove")
    String RemoveSmartphoneFromCompareList(@RequestParam(value="phone", required = false) Long phone,
                                           Model model){
        if(phone == null) {
            selectedSmartphones.clear();
            return "index";
        }
        selectedSmartphones.removeIf(a -> Objects.equals(a.getName(), smartphoneService.getSmartphoneById(phone).getName()));
        return "index";
    }
}
