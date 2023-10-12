package com.mrprokey.misereremei2.model;

public class User {
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

        @OneToMany(mappedBy = "player")
        private Set<PlayerInventory> inventory;


        public User() {
        }

        public User(Long id, String username, String password, Short userLevel) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.userLevel = userLevel;
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

        public Short getUserLevel() {
            return userLevel;
        }

        public void setUserLevel(Short userLevel) {
            this.userLevel = userLevel;
        }
    }
