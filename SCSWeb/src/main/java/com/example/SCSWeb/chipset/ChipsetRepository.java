package com.example.SCSWeb.chipset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChipsetRepository extends JpaRepository<Chipset, Long> {}
