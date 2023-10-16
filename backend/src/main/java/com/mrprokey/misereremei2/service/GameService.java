package com.mrprokey.misereremei2.service;

import com.mrprokey.misereremei2.model.GameState;
import com.mrprokey.misereremei2.repository.GameStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final GameStateRepository gameStateRepository;

    public GameService(GameStateRepository gameStateRepository) {
        this.gameStateRepository = gameStateRepository;
    }

    public GameState moveUserToLocation(Long userId, String newLocation) {
        // Implement movement logic
        GameState gameState = gameStateRepository.findByUserId(userId).get(0);
        gameState.setCurrentLocation(newLocation);
        return gameStateRepository.save(gameState);
    }

    public GameState userAction(Long userId, String action) {
        // Implement user action logic, e.g., initiate a battle or interaction
        GameState gameState = gameStateRepository.findByUserId(userId).get(0);
        // Modify gameState based on action
        return gameStateRepository.save(gameState);
    }
}
