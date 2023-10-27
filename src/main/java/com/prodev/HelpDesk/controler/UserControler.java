package com.prodev.HelpDesk.controler;

import com.prodev.HelpDesk.config.JwtUtil;
import com.prodev.HelpDesk.model.UserDetai;
import com.prodev.HelpDesk.payload.LoginResponse;
import com.prodev.HelpDesk.payload.UserDetail;
import com.prodev.HelpDesk.service.impl.JavaMail;
import com.prodev.HelpDesk.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserControler {
    private UserService userService;
    private JavaMail javaMail;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserControler(UserService userService,JavaMail javaMail,AuthenticationManager authenticationManager,PasswordEncoder passwordEncoder,JwtUtil jwtUtil){
        this.userService=userService;
        this.javaMail=javaMail;
        this.passwordEncoder=passwordEncoder;
        this.jwtUtil=jwtUtil;
        this.authenticationManager=authenticationManager;
    }

    @GetMapping("/getUsers")
    public List<String> getUsers()
    {
        return userService.getUserAll().stream().map(userDetai -> {return  userDetai.name;}).toList();
    }
    @GetMapping("/getCurUser")
    public UserDetai getCurrentUser(Principal principal)
    {
        System.out.println("working properly");
        return userService.getUserDetail(principal.getName());
    }

    @PostMapping("/register")
    public Boolean signUp(@RequestBody UserDetai userDetail ){
        userDetail.setPassword(passwordEncoder.encode(userDetail.getPassword()));
        return  userService.saveData(userDetail);
    }
    @PostMapping("/api/login")
    public ResponseEntity<LoginResponse> signIn(@RequestBody UserDetail userDetai){
        Authentication authentication=null;
        LoginResponse loginResponse=new LoginResponse();
        try{
            authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDetai.getUsername(), userDetai.getPassword()));
            System.out.println(authentication+"data");
            loginResponse.setAuth(authentication.isAuthenticated());
            loginResponse.setStatus(200);
            loginResponse.setToken(jwtUtil.generateToken(userDetai));
            System.out.println(authentication.getDetails());
            loginResponse.setRespMessage("Login successfull");
        }catch (Exception e){
            loginResponse.setAuth(false);
            loginResponse.setStatus(401);
            loginResponse.setToken(null);
            String token = this.jwtUtil.generateToken(userDetai);
            loginResponse.setRespMessage(e.getMessage());
        }
        return ResponseEntity.ok(loginResponse);
    }
    @GetMapping("/test")
    public String test(){
        javaMail.sendMail();
        return "thanku";
    }
}
