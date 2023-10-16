package com.mrprokey.misereremei2.repository;

import com.mrprokey.misereremei2.model.GameState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameStateRepository extends JpaRepository<GameState, Long> {
    List<GameState> findByUserId(Long userId);

    // Azokat az állapotokat keresi, ahol a játékos egészsége egy adott érték alatt van:
    List<GameState> findByHealthLessThan(Integer health);

    // Azokat a GameState entitásokat keresi, amelyek a megadott helyszínen találhatók:
    List<GameState> findByCurrentLocation(String location);

    // Vagy egy komplexebb lekérdezés, amely az adatbázis szintjén történő szűrést használ:
    @Query("SELECT gs FROM GameState gs WHERE gs.user.username = :username AND gs.currentLocation = :location")
    List<GameState> findByUsernameAndCurrentLocation(@Param("username") String username, @Param("location") String location);
}
