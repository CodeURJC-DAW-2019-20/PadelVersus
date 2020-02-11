package com.example.padelversus;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initDatabase() { //Para guardarlo en la bbdd al inicializar
    	
    	userRepository.save(new User("user", "pass", "ROLE_USER"));
		userRepository.save(new User("admin", "adminpass", "ROLE_USER", "ROLE_ADMIN"));
    }

}
