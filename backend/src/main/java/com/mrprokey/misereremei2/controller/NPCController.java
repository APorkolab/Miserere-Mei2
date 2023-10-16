package com.mrprokey.misereremei2.controller;

import com.mrprokey.misereremei2.service.NPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/npc")
public class NPCController {

    @Autowired
    private NPCService npcService;

    @PostMapping("/communicate/{npcId}")
    public ResponseEntity<String> communicateWithNPC(@PathVariable Long npcId, @RequestBody String playerMessage) {
        return ResponseEntity.ok(npcService.communicateWithNPC(npcId, playerMessage));
    }

    // ... További végpontok ...
}
