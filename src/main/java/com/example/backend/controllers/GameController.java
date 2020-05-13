package com.example.backend.controllers;

import com.example.backend.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class GameController {

    @Autowired
    GameService service;
}