package com.prodev.HelpDesk.service.impl;

import com.prodev.HelpDesk.model.UserDetai;
import com.prodev.HelpDesk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class  UserService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        UserDetails userDetails;
        try{
           userDetails= (UserDetails) userRepository.findAll().stream().filter(userDetai -> userDetai.getEmail().equalsIgnoreCase(username)).findFirst().get();
        }catch (NullPointerException e){
            throw new UsernameNotFoundException("Username is now Available");
        }
//        userRepository.findAll().stream().filter(userDetai -> userDetai.getEmail().equalsIgnoreCase(username)).findFirst().get();
        return userDetails;
    }

    public Boolean saveData(UserDetai userDetail) {
        userRepository.save(userDetail);
        return true;
    }
}
