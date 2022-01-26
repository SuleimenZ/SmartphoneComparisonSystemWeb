package com.example.SCSWeb.chipset;


import com.example.SCSWeb.smartphone.Smartphone;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chipset {
    @Id
    @SequenceGenerator(name="chipset_sequence",
            sequenceName="chipset_sequence",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="chipset_sequence")
    @Column(name = "chipset_id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "chipset")
    private List<Smartphone> smartphoneList;

    //CONSTRUCTORS
    public Chipset() {}

    public Chipset(String name) {
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

