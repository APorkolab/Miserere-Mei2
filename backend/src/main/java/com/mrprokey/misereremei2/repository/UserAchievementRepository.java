package com.mrprokey.misereremei2.repository;

import com.mrprokey.misereremei2.model.Achievement;
import com.mrprokey.misereremei2.model.User;
import com.mrprokey.misereremei2.model.UserAchievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAchievementRepository extends JpaRepository<UserAchievement, Long> {
    List<UserAchievement> findByUser(User user);
    UserAchievement findByUserAndAchievement(User user, Achievement achievement);
}