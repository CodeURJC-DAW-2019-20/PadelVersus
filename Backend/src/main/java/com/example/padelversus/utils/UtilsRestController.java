package com.example.padelversus.utils;

import com.example.padelversus.match.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UtilsRestController {
    @Autowired
    MatchRepository matchRepository;

    @GetMapping("/dates")
    public ResponseEntity<List<String>> getDates() {
        List<String> dates = matchRepository.findAllNotPlayedDates().stream().map(Date::toString).collect(Collectors.toList());
        return new ResponseEntity<>(dates, HttpStatus.OK);
    }
}
