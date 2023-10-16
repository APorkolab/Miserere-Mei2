package com.mrprokey.misereremei2.controller;

import com.mrprokey.misereremei2.model.GameState;
import com.mrprokey.misereremei2.service.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/move")
    public GameState move(@RequestParam Long userId, @RequestParam String newLocation) {
        return gameService.moveUserToLocation(userId, newLocation);
    }

    @PostMapping("/action")
    public GameState action(@RequestParam Long userId, @RequestParam String action) {
        return gameService.userAction(userId, action);
    }
}
