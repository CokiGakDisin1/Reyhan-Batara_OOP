package com.reyhan.backend.Controller;

import com.reyhan.backend.model.Score;
import com.reyhan.backend.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public ResponseEntity


}
