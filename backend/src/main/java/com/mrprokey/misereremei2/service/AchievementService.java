package com.mrprokey.misereremei2.service;

import com.mrprokey.misereremei2.model.Achievement;
import com.mrprokey.misereremei2.model.User;
import com.mrprokey.misereremei2.model.UserAchievement;
import com.mrprokey.misereremei2.repository.AchievementRepository;
import com.mrprokey.misereremei2.repository.UserAchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    @Autowired
    private UserAchievementRepository userAchievementRepository;

    public void unlockAchievement(User user, Achievement achievement) {
        if (userAchievementRepository.findByUserAndAchievement(user, achievement) == null) {
            UserAchievement userAchievement = new UserAchievement();
            userAchievement.setUser(user);
            userAchievement.setAchievement(achievement);
            userAchievement.setAchievedOn(new Date());
            userAchievementRepository.save(userAchievement);
        }
    }

    public List<UserAchievement> getUserAchievements(User user) {
        return userAchievementRepository.findByUser(user);
    }
}