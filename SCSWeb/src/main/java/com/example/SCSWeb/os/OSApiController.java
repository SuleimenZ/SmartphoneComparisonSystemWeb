package com.example.SCSWeb.os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/os")
public class OSApiController {

    private final OSService osService;

    @Autowired
    public OSApiController(OSService osService) {
        this.osService = osService;
    }

    @GetMapping
    public List<OS> getOS(){
        return osService.getOS();
    }

    @GetMapping(path = "/{id}")
    public OS getOSById(@PathVariable Long id) {return osService.getOSById(id);}
}
