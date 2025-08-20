package com.theCoderKushagra.chatApp.Vixify.service;

import com.theCoderKushagra.chatApp.Vixify.entity.Status;
import com.theCoderKushagra.chatApp.Vixify.entity.Users;
import com.theCoderKushagra.chatApp.Vixify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // USER Methods
    public void saveNewUser(Users users){
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setRoles(Arrays.asList("USER"));
        userRepository.save(users);
    }

    public Users findByUserName(String user){
        return userRepository.findByUserName(user);
    }

    public String generateSixDigitNumber() {
        String uuidDigitsOnly = UUID.randomUUID().toString().replaceAll("[^0-9]", "");
        // Ensure we have at least 6 digits
        while (uuidDigitsOnly.length() < 6) {
            uuidDigitsOnly += UUID.randomUUID().toString().replaceAll("[^0-9]", "");
        }
        // Extract the first 6 digits
        return uuidDigitsOnly.substring(0, 6);
    }

    public void statusOnline(Users user){
        var userInDb = userRepository.findByUserName(user.getUserName());
        if (userInDb != null) {
            userInDb.setStatus(Status.ONLINE);
            userRepository.save(userInDb);
        }
    }

    public void statusOffline(Users user){
        var userInDb = userRepository.findByUserName(user.getUserName());
        if (userInDb != null) {
            userInDb.setStatus(Status.OFFLINE);
            userRepository.save(userInDb);
        }
    }

    public List<Users> onlineMembers(){
        return userRepository.findAllByStatus(Status.ONLINE);
    }
}
