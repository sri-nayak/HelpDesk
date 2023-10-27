package com.prodev.HelpDesk.service.impl;

import com.prodev.HelpDesk.model.UserDetai;
import com.prodev.HelpDesk.payload.UserDetail;
import com.prodev.HelpDesk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  UserService  implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        UserDetail userDetails;
//        System.out.println("from user"+username);
//        userRepository.save(new UserDetai("sridhara","nayaksridhar923@gmail.com",passwordEncoder.encode("Nayak@923")));
        try{
           userDetails= new UserDetail( userRepository.findAll().stream().filter(userDetai -> userDetai.getEmail().equalsIgnoreCase(username)).findFirst().get());
        }catch (NullPointerException e){
            throw new UsernameNotFoundException("Username is now Available");
        }
//        userRepository.findAll().stream().filter(userDetai -> userDetai.getEmail().equalsIgnoreCase(username)).findFirst().get();
        return userDetails;
    }
    public UserDetai getUserDetail(String name){
        return userRepository.findAll().stream().filter(userDetai -> userDetai.getEmail().equalsIgnoreCase(name)).findFirst().get();

    }

    public Boolean saveData(UserDetai userDetail) {
        userRepository.save(userDetail);
        return true;
    }
    public List<UserDetai> getUserAll(){
       return  userRepository.findAll().stream().toList();
    }
}
