package com.example.padelversus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/match")
public class MatchController {
    @Autowired
    MatchRepository matchRepository;

    @GetMapping("/{id}")
    public String match
}
