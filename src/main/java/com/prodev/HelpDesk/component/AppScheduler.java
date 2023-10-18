package com.prodev.HelpDesk.component;

import com.prodev.HelpDesk.service.impl.JavaMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppScheduler {
    public JavaMail javaMail;
    @Autowired
    public AppScheduler(JavaMail javaMail){
        this.javaMail=javaMail;
    }

    @Scheduled(cron = "0 * 13 * * ?")
    public void testRunner() {
//        javaMail.sendMail();
        System.out.println("working");
    }
}
