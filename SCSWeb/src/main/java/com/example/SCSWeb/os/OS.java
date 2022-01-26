package com.example.SCSWeb.os;

import com.example.SCSWeb.smartphone.Smartphone;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "os", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "version"})})
public class OS {
    @Id
    @SequenceGenerator(name="os_sequence",
            sequenceName="os_sequence",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="os_sequence")
    @Column(name = "os_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "version", nullable = false)
    private String version;

    @JsonIgnore
    @OneToMany(mappedBy = "os")
    private List<Smartphone> smartphoneList;

    //METHODS


    @Override
    public String toString() {
        return name + " " + version;
    }

    //CONSTRUCTORS
    public OS() {}

    public OS(String name, String version){
        this.name = name;
        this.version = version;
    }

    //GETTERS AND SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    public List<Smartphone> getSmartphoneList() { return smartphoneList; }


}
