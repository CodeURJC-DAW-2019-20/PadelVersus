package com.example.padelversus;

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

    public void sendNotification(Player player) throws MailException {  //Send an email

        SimpleMailMessage mail = new SimpleMailMessage();
        //mail.setTo(player.getEmail());
        mail.setTo("mchr1967@gmail.com");
        mail.setFrom("ach.juegos@gmail.com");
        mail.setSubject("HOLAAA");
        mail.setText("Bienvenido a la pagina!");

        javaMailSender.send(mail);
    }
}
