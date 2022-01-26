package com.example.SCSWeb.smartphone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService {
    private final SmartphoneRepository smartphoneRepository;

    @Autowired
    public SmartphoneService(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    public List<Smartphone> getSmartphones() {
        return smartphoneRepository.findAll();
    }

    public Smartphone getSmartphoneById(Long id) {
        return smartphoneRepository.findById(id).orElse(null);
    }

    public Boolean exists(Smartphone smartphone){
        return smartphoneRepository.exists(Example.of(smartphone));
    }

    public Boolean existsById(Long id){
        return smartphoneRepository.existsById(id);
    }
}
