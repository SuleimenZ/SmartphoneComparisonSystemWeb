package com.example.SCSWeb.os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class OSService {
    private final OSRepository osRepository;

    @Autowired
    public OSService(OSRepository osRepository) {
        this.osRepository = osRepository;
    }

    public List<OS> getOS(){
        return osRepository.findAll();
    }

    public OS getOSById(Long id){
        return osRepository.findById(id).orElse(null);
    }

    public Boolean exists(OS os){
        return osRepository.exists(Example.of(os));
    }

    public Boolean existsById(Long id){
        return osRepository.existsById(id);
    }
}
