package com.mrprokey.misereremei2.model;

import jakarta.persistence.*;

import java.util.Set;

    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false)
        private String password;

        @Column(nullable = false)
        private Short userLevel;

        @OneToMany(mappedBy = "user")
        private Set<PlayerInventory> inventory;


        public User() {
        }

        public User(Long id, String username, String password, Short userLevel, Set<PlayerInventory> inventory) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.userLevel = userLevel;
            this.inventory = inventory;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Set<PlayerInventory> getInventory() {
            return inventory;
        }

        public void setInventory(Set<PlayerInventory> inventory) {
            this.inventory = inventory;
        }

        public Short getUserLevel() {
            return userLevel;
        }

        public void setUserLevel(Short userLevel) {
            this.userLevel = userLevel;
        }
    }