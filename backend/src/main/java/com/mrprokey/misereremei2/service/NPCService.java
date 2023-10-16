package com.mrprokey.misereremei2.service;

import com.mrprokey.misereremei2.model.NPC;
import com.mrprokey.misereremei2.repository.NPCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NPCService {

    @Autowired
    private NPCRepository npcRepository;

    public String communicateWithNPC(Long npcId, String playerMessage) {
        Optional<NPC> npcOptional = npcRepository.findById(npcId);

        if(npcOptional.isPresent()) {
            NPC npc = npcOptional.get();
            if (playerMessage.contains("hello")) {
                return "Hello, " + npc.getName() + "!";
            }
            // ... További egyszerű if-else logikai válaszok ...
            return npc.getDefaultResponse();
        }

        return "NPC not found.";
    }

    // ... További metódusok ...
}
