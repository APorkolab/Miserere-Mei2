package com.mrprokey.misereremei2.controller;

import com.mrprokey.misereremei2.model.User;
import com.mrprokey.misereremei2.model.UserAchievement;
import com.mrprokey.misereremei2.service.AchievementService;
import com.mrprokey.misereremei2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;
    private UserService userService;

    @GetMapping
    public List<UserAchievement> getUserAchievements(@RequestParam("userId") Long userId) {
        User user = userService.findUserById(userId);
        return achievementService.getUserAchievements(user);
    }
}