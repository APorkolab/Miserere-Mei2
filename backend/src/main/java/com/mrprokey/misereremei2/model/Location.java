package com.mrprokey.misereremei2.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "location")
    private Set<LocationInventory> inventory;
}

