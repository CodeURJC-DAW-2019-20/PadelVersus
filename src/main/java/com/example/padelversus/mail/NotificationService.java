package com.example.padelversus.mail;

import com.example.padelversus.player.Player;
import com.example.padelversus.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(User user) throws MailException {  //Send an email
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getMail());
        mail.setSubject("WELCOME TO PADEL VERSUS!");
        mail.setText("Welcome to our page! Thanks  for signing up in the best web for padel tournaments.");
        javaMailSender.send(mail);
    }
}
