package com.example.SCSWeb.brand;


import com.example.SCSWeb.smartphone.Smartphone;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @SequenceGenerator(name="brand_sequence",
            sequenceName = "brand_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator= "brand_sequence")
    @Column(name = "brand_id")
    private Long id;

    @Column(name="name", unique = true, nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    private List<Smartphone> smartphoneList;

    //CONSTRUCTORS
    public Brand() {}

    public Brand(String name) {
        this.name = name;
    }

    //GETTERS AND SETTERS
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Smartphone> getSmartphoneList() {
        return smartphoneList;
    }
}

