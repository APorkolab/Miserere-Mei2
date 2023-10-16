package com.mrprokey.misereremei2.service;

import com.mrprokey.misereremei2.model.StoryLog;
import com.mrprokey.misereremei2.repository.StoryLogRepository;
import com.mrprokey.misereremei2.util.TimeUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StoryLogService {

    private final StoryLogRepository storyLogRepository;

    public StoryLogService(StoryLogRepository storyLogRepository) {
        this.storyLogRepository = storyLogRepository;
    }

    public String getRelativeTimeForLog(StoryLog storyLog) {
        LocalDate localDate = TimeUtils.toLocalDate(storyLog.getTimestamp());
        return TimeUtils.getRelativeTime(localDate.atStartOfDay());
    }

    public StoryLog saveLog(StoryLog storyLog) {
        return storyLogRepository.save(storyLog);
    }

    public List<StoryLog> getAllLogs() {
        return storyLogRepository.findAll();
    }
}

