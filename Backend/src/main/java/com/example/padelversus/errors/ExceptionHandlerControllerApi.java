package com.example.padelversus.errors;

import com.example.padelversus.match.MatchRestController;
import com.example.padelversus.player.PlayerRestController;
import com.example.padelversus.team.TeamsRestController;
import com.example.padelversus.team.TeamxRestController;
import com.example.padelversus.tournament.TournamentRestController;
import com.example.padelversus.user.UserRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(assignableTypes = {MatchRestController.class, PlayerRestController.class,
        TeamsRestController.class, TeamxRestController.class, TournamentRestController.class, UserRestController.class})
public class ExceptionHandlerControllerApi {
    Logger logger = LoggerFactory.getLogger(ExceptionHandlerControllerApi.class);

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ResponseEntity<String> defaultErrorHandler(HttpServletRequest request, Exception e) {
        logger.error("ERROR in request: " + request.getServletPath() + " exeception thrown " + e);
        e.printStackTrace();
        return new ResponseEntity<>("Unexpected error ocurs", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
