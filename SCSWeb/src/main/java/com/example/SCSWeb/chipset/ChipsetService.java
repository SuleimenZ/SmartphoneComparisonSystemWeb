package com.example.SCSWeb.chipset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ChipsetService {
    private final ChipsetRepository chipsetRepository;

    @Autowired
    public ChipsetService(ChipsetRepository chipsetRepository) {
        this.chipsetRepository = chipsetRepository;
    }

    public List<Chipset> getChipsets(){
        return chipsetRepository.findAll();
    }

    public Chipset getChipsetById(Long id){
        return chipsetRepository.findById(id).orElse(null);
    }

    public Boolean exists(Chipset chipset){
        return chipsetRepository.exists(Example.of(chipset));
    }

    public Boolean existsById(Long id){
        return chipsetRepository.existsById(id);
    }
}
