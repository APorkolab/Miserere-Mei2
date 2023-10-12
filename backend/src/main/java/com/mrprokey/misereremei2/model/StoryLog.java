package com.mrprokey.misereremei2.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class StoryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Enumerated(EnumType.STRING)
    private EventType eventType;  // 1. Esemény típusa

    @ManyToMany
    @JoinTable(
            name = "storylog_location",
            joinColumns = @JoinColumn(name = "storylog_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private Set<Location> relatedLocations;  // 2. Kapcsolódó helyszínek

    @ManyToMany
    @JoinTable(
            name = "storylog_character",
            joinColumns = @JoinColumn(name = "storylog_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private Set<NPC> relatedCharacters;  // 2. Kapcsolódó karakterek

    @ElementCollection
    private Set<String> multimediaLinks;  // 2. Multimédia linkek

    @ElementCollection
    private Set<String> playerNotes;  // 3. Játékos megjegyzések

    @Enumerated(EnumType.STRING)
    private ImportanceLevel importanceLevel;  // 1. Fontosság

    // Getterek, setterek, stb.

    public enum EventType {
        DIALOGUE, FIGHT, DISCOVERY, OTHER
    }

    public enum ImportanceLevel {
        CRITICAL, IMPORTANT, NORMAL
    }
}
