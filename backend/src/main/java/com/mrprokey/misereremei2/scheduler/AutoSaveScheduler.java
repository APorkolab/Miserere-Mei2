package com.mrprokey.misereremei2.scheduler;

import com.mrprokey.misereremei2.model.GameState;
import com.mrprokey.misereremei2.repository.GameStateRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoSaveScheduler {

    private final GameStateRepository gameStateRepository;

    public AutoSaveScheduler(GameStateRepository gameStateRepository) {
        this.gameStateRepository = gameStateRepository;
    }

    @Scheduled(fixedRate = 600000) // 10 perces intervallumokban
    public void autoSave() {
        List<GameState> allGameStates = gameStateRepository.findAll();
        gameStateRepository.saveAll(allGameStates);
    }
}
