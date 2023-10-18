package com.mrprokey.misereremei2.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class GameState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    @Column(name = "current_location", nullable = false)
    private String currentLocation;

    @Column(nullable = false)
    private Integer health;

    public GameState(User user) {
        this.user = user;
    }

    public GameState() {

    }

    public GameState(User user, String currentLocation, Integer health) {
        this.user = user;
        this.currentLocation = currentLocation;
        this.health = health;
    }

    public GameState(User user, String currentLocation) {
        this.user = user;
        this.currentLocation = currentLocation;
        this.health = 100;
    }

    public GameState(User user, Integer health) {
        this.user = user;
        this.currentLocation = "home";
        this.health = health;
    }

    public GameState(User user, String currentLocation, Integer health, Long id) {
        this.user = user;
        this.currentLocation = currentLocation;
        this.health = health;
        this.id = id;
    }

    public GameState(User user, String currentLocation, Long id) {
        this.user = user;
        this.currentLocation = currentLocation;
        this.health = 100;
        this.id = id;
    }
}


