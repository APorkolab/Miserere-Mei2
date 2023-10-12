package com.mrprokey.misereremei2.service;

public class StoryLogService {

    public String getRelativeTimeForLog(StoryLog storyLog) {
        return TimeUtils.getRelativeTime(storyLog.getTimestamp());
    }
}
