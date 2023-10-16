package com.mrprokey.misereremei2.controller;

import com.mrprokey.misereremei2.model.StoryLog;
import com.mrprokey.misereremei2.service.StoryLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storylog")
public class StoryLogController {

    private final StoryLogService storyLogService;

    public StoryLogController(StoryLogService storyLogService) {
        this.storyLogService = storyLogService;
    }

    @PostMapping
    public ResponseEntity<StoryLog> createLog(@RequestBody StoryLog storyLog) {
        return ResponseEntity.ok(storyLogService.saveLog(storyLog));
    }

    @GetMapping
    public ResponseEntity<List<StoryLog>> getAllLogs() {
        return ResponseEntity.ok(storyLogService.getAllLogs());
    }

}
