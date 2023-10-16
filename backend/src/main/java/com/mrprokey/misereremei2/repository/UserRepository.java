package com.mrprokey.misereremei2.repository;

import com.mrprokey.misereremei2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    // Lekérdezés, ami alapján lekérdezhetők a felhasználók egy bizonyos szint felett:
    List<User> findByUserLevelGreaterThan(Short userLevel);

    // Lekérdezés, ami visszadja a felhasználókat egy adott szinttől kezdve:
    List<User> findByUserLevel(Short userLevel);

    // Komplexebb lekérdezés, ami a felhasználók jelszavát és szintjét ellenőrzi:
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password AND u.userLevel >= :userLevel")
    Optional<User> findByUsernameAndPasswordAndMinimumUserLevel(@Param("username") String username, @Param("password") String password, @Param("userLevel") Short userLevel);

    // További ötletek esetleges lekérdezésekhez:

    // Az összes felhasználó lekérdezése, akiknek van valami a leltárukban:
    @Query("SELECT u FROM User u WHERE size(u.inventory) > 0")
    List<User> findAllWithInventory();

    // A felhasználó lekérdezése leltártárgy ID alapján (feltéve, hogy a PlayerInventory entitás tartalmaz egy egyedi ID-t vagy valami hasonlót):
    @Query("SELECT u FROM User u JOIN u.inventory i WHERE i.id = :inventoryItemId")
    Optional<User> findByInventoryItemId(@Param("inventoryItemId") Long inventoryItemId);
}
