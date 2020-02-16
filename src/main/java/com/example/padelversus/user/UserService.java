package com.example.padelversus.user;

import com.example.padelversus.mail.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    @Autowired
    private NotificationService notificationService;

    //Saves a (copy with ROLE_USER) user if succes return user name if not return null (user already exists)
    public String saveUser(User user) {
        User u = userRepository.findByName(user.getName());
        if (u == null) {
            User u_mail = userRepository.findByMail(user.getMail());
            if(u_mail == null) {
                User userSave = new User();
                userSave.setName(user.getName());
                userSave.setPasswordHash(user.getPasswordHash());
                userSave.setMail(user.getMail());
                userSave.setRol("USER_ROLE");
                userRepository.save(userSave);
                notificationService.sendNotification(user);
                return userSave.getName();
            }else{
                return null;
            }
        } else {
            return null;
        }
    }
}
