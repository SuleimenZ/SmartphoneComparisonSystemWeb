package com.example.SCSWeb.os;

import com.example.SCSWeb.smartphone.Smartphone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path="/os")
public class OSController {

    private final OSService osService;

    @Autowired
    public OSController(OSService osService) {
        this.osService = osService;
    }

    @GetMapping
    String getOS(Model model){
        model.addAttribute("osList", osService.getOS());
        return "os/osList";
    }

    @GetMapping(path = "/{id}")
    String getOS(Model model, @PathVariable Long id){
        model.addAttribute("id", id);
        if(!osService.existsById(id)){ return "os/osNotFound"; }

        OS os = osService.getOSById(id);
        model.addAttribute("os", os);
        return "os/os";
    }
}
