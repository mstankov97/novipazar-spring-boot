package com.example.pazar43.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private Long price;

    private String city;


    @OneToMany(mappedBy = "item",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Image> images= new HashSet<>();

    @OneToMany(mappedBy = "item",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Category> categories=new HashSet<>();

}
