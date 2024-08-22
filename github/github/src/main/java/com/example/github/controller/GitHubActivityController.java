package com.example.github.controller;

import com.example.github.service.GitHubActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubActivityController {

    @Autowired
    private GitHubActivityService gitHubActivityService;

    @GetMapping("/activity")
    public String getGitHubActivity(@RequestParam String username) {
        return gitHubActivityService.fetchRecentActivity(username);
    }
}