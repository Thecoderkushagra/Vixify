package com.theCoderKushagra.chatApp.Vixify.controller;

import com.theCoderKushagra.chatApp.Vixify.dto.RequestUserDto;
import com.theCoderKushagra.chatApp.Vixify.entity.Users;
import com.theCoderKushagra.chatApp.Vixify.repository.UserRepository;
import com.theCoderKushagra.chatApp.Vixify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-changes")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/logout")
    @SendTo("/user/status")
    public ResponseEntity<String> disconnectUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        Users user = userRepository.findByUserName(userName);
        userService.statusOffline(user);
        return new ResponseEntity<>("Logout",HttpStatus.OK);
    }

    @PutMapping("/change-info")
    public ResponseEntity<Users> updateInfo(@RequestBody RequestUserDto user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        Users userInDb = userService.findByUserName(userName);

        if(userInDb != null){
            userInDb.setPassword(user.getPassword());
            userInDb.setUserName(user.getUserName());
            userService.saveNewUser(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteByUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
