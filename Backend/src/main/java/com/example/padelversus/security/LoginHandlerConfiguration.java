package com.example.padelversus.security;

import com.example.padelversus.player.Player;
import com.example.padelversus.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Configuration
public class LoginHandlerConfiguration implements WebMvcConfigurer {
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor(playerRepository));
    }
}

class LoginHandlerInterceptor extends HandlerInterceptorAdapter {

    private PlayerRepository playerRepository;

    public LoginHandlerInterceptor(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void postHandle(final HttpServletRequest request,
                           final HttpServletResponse response, final Object handler,
                           final ModelAndView modelAndView) {

        try {
            String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Optional<Player> player = playerRepository.findByUserName(username);
            boolean logged = !username.equals("anonymousUser");
            boolean admin = username.equals("admin");
            boolean playerisPresent = player.isPresent();
            if(player.isPresent()) {
                modelAndView.addObject("playerIdFH", player.get().getId());
            }
            modelAndView.addObject("logged", logged);
            modelAndView.addObject("playerIdIsPresentFH",playerisPresent);
            modelAndView.addObject("admin", admin);
        } catch (Exception e) {

        }

    }
}