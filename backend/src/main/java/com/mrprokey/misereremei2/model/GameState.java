package com.mrprokey.misereremei2.model;

public class GameState {
    @Entity
    @Table(name = "game_states")
    public class GameState {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private User user;

        @Column(name = "current_location", nullable = false)
        private String currentLocation;

        @Column(nullable = false)
        private Integer health;

        // további mezők, konstruktor, getterek és setterek...
    }

}
