package com.mrprokey.misereremei2.repository;

import com.mrprokey.misereremei2.model.NPC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NPCRepository extends JpaRepository<NPC, Long> {
    Optional<NPC> findByName(String name);
    List<NPC> findByLocationId(Long locationId);
    Optional<NPC> findById(Long npcId);
    }

