package com.prodev.HelpDesk.service.impl;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class JavaMail {
    JavaMailSender javaMailSender;
    @Autowired
    public JavaMail(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }
    public void sendMail(){
        SimpleMailMessage simpleMessage=new SimpleMailMessage();
        simpleMessage.setFrom("sridhara.nayak@prodevans.com");
        simpleMessage.setTo("nayaksridhar923@gmail.com");
        simpleMessage.setSubject("hii this is test mail");
        simpleMessage.setText("hey this is a test mail\n sending from testing purpose mail");
        javaMailSender.send(simpleMessage);
    }
    public void sendMail(String subj,String msg,String mailId){
        SimpleMailMessage simpleMessage=new SimpleMailMessage();
        simpleMessage.setFrom("sridhara.nayak@prodevans.com");
        simpleMessage.setTo(mailId);
        simpleMessage.setSubject(subj);
        simpleMessage.setText(subj);
        javaMailSender.send(simpleMessage);
    }
}
