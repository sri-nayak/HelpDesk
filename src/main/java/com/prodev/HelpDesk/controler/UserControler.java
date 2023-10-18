package com.prodev.HelpDesk.controler;

import com.prodev.HelpDesk.model.UserDetai;
import com.prodev.HelpDesk.service.impl.JavaMail;
import com.prodev.HelpDesk.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControler {
    UserService userService;
    JavaMail javaMail;
    @Autowired
    public UserControler(UserService userService,JavaMail javaMail){
        this.userService=userService;
        this.javaMail=javaMail;
    }

    @PostMapping("/register")
    public Boolean signUp(@RequestBody UserDetai userDetail ){
        return userService.saveData(userDetail);
    }
    @PostMapping("/login")
    public void signIn(@RequestBody UserDetai userDetai){
//        return true;
    }
    @GetMapping("/test")
    public String test(){
        javaMail.sendMail();
        return "thanku";
    }
}
