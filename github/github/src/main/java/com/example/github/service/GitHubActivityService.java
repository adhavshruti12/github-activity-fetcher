package com.example.github.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubActivityService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String GITHUB_API_URL = "https://api.github.com/users/%s/events";

    public String fetchRecentActivity(String username) {
        String url = String.format(GITHUB_API_URL, username);
        try {
            String response = restTemplate.getForObject(url, String.class);
            return response != null ? response : "No data found.";
        } catch (Exception e) {
            return "Error fetching data: " + e.getMessage();
        }
    }
}