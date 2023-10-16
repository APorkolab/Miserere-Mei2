package com.mrprokey.misereremei2.model;

import jakarta.persistence.*;

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


    public enum EventType {
        DIALOGUE, FIGHT, DISCOVERY, OTHER
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return (timestamp != null) ? new Date(timestamp.getTime()) : null;
    }


    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Set<Location> getRelatedLocations() {
        return relatedLocations;
    }

    public void setRelatedLocations(Set<Location> relatedLocations) {
        this.relatedLocations = relatedLocations;
    }

    public Set<NPC> getRelatedCharacters() {
        return relatedCharacters;
    }

    public void setRelatedCharacters(Set<NPC> relatedCharacters) {
        this.relatedCharacters = relatedCharacters;
    }

    public Set<String> getMultimediaLinks() {
        return multimediaLinks;
    }

    public void setMultimediaLinks(Set<String> multimediaLinks) {
        this.multimediaLinks = multimediaLinks;
    }

    public Set<String> getPlayerNotes() {
        return playerNotes;
    }

    public void setPlayerNotes(Set<String> playerNotes) {
        this.playerNotes = playerNotes;
    }

    public ImportanceLevel getImportanceLevel() {
        return importanceLevel;
    }

    public void setImportanceLevel(ImportanceLevel importanceLevel) {
        this.importanceLevel = importanceLevel;
    }

    public enum ImportanceLevel {
        CRITICAL, IMPORTANT, NORMAL
    }
}
