package com.reyhan.backend.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class HealthController {

    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("status", "UP");
        res.put("message", "Backend is running");
        res.put("timestamp", System.currentTimeMillis());
        return res;
    }

    @GetMapping("/info")
    public Map<String, Object> info() {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("application", "CS6 Backend");
        res.put("version", "1.0");
        res.put("description", "Backend for Jetpack Joyride");
        Map<String, String> endpoints = new HashMap<String, String>();
        endpoints.put("players", "/api/players");
        endpoints.put("scores", "/api/scores");
        endpoints.put("leaderboard", "/api/scores/leaderboard");
        endpoints.put("health", "/api/health");
        res.put("endpoints", endpoints);
        return res;
    }
}

