package com.example.padelversus.errors;

import com.example.padelversus.admin.AdminController;
import com.example.padelversus.index.IndexController;
import com.example.padelversus.player.PlayerController;
import com.example.padelversus.team.TeamsController;
import com.example.padelversus.team.TeamxController;
import com.example.padelversus.tournament.Tournament;
import com.example.padelversus.tournament.TournamentController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(assignableTypes = {AdminController.class, IndexController.class,  PlayerController.class,
        TeamsController.class, TeamxController.class, TournamentController.class})
public class ExceptionHandlerController {

    Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public String defaultErrorHandler(HttpServletRequest request, Exception e) {
        logger.error("ERROR in request: " + request.getServletPath() + " exeception thrown " + e);
        e.printStackTrace();
        return "error";
    }
}