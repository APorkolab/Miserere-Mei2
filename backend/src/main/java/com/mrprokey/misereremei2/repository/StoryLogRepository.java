package com.mrprokey.misereremei2.repository;

import com.mrprokey.misereremei2.model.StoryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StoryLogRepository extends JpaRepository<StoryLog, Long> {
    List<StoryLog> findByTimestamp(Date timestamp);

    List<StoryLog> findByEventType(StoryLog.EventType eventType);

    @Query("SELECT s FROM StoryLog s WHERE s.importanceLevel = :importanceLevel")
    List<StoryLog> findByImportanceLevel(@Param("importanceLevel") StoryLog.ImportanceLevel importanceLevel);

    // Lekérdezés a leírás alapján (például szövegrészlet alapján)
    List<StoryLog> findByDescriptionContaining(String descriptionFragment);

    // Lekérdezés egy bizonyos időintervallumon belül történt eseményekre
    List<StoryLog> findByTimestampBetween(Date startDate, Date endDate);

    // Lekérdezés, ami visszaadja az összes eseményt egy bizonyos helyszín alapján
    @Query("SELECT s FROM StoryLog s JOIN s.relatedLocations l WHERE l.id = :locationId")
    List<StoryLog> findByRelatedLocationId(@Param("locationId") Long locationId);

    // Lekérdezés, ami visszaadja az összes eseményt egy bizonyos karakterrel kapcsolatban
    @Query("SELECT s FROM StoryLog s JOIN s.relatedCharacters c WHERE c.id = :characterId")
    List<StoryLog> findByRelatedCharacterId(@Param("characterId") Long characterId);

    // Lekérdezés, ami visszaadja az összes eseményt, ahol egy bizonyos multimédia link szerepel
    @Query("SELECT s FROM StoryLog s WHERE :multimediaLink MEMBER OF s.multimediaLinks")
    List<StoryLog> findByMultimediaLink(@Param("multimediaLink") String multimediaLink);

    // Lekérdezés egy bizonyos fontossági szint alapján, rendezve időbélyeg szerint
    List<StoryLog> findByImportanceLevelOrderByTimestampDesc(StoryLog.ImportanceLevel importanceLevel);
}
