package com.example.padelversus.security;

import javax.annotation.PostConstruct;

import com.example.padelversus.user.User;
import com.example.padelversus.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initDatabase() { //Para guardarlo en la bbdd al inicializar
    	
    	//userRepository.save(new User("user", "pass", "prueba@gmail.com", null, "ROLE_USER"));
		//userRepository.save(new User("admin", "adminpass","procesosoftg1@gmail.com", null, "ROLE_USER", "ROLE_ADMIN"));
    }

}
