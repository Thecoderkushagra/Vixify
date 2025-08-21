package com.theCoderKushagra.chatApp.Vixify.controller;

import com.theCoderKushagra.chatApp.Vixify.cache.OtpRedisCache;
import com.theCoderKushagra.chatApp.Vixify.cache.UserRedis;
import com.theCoderKushagra.chatApp.Vixify.dto.RequestUserDto;
import com.theCoderKushagra.chatApp.Vixify.dto.VarifyUserDto;
import com.theCoderKushagra.chatApp.Vixify.entity.Users;
import com.theCoderKushagra.chatApp.Vixify.security.JwtUtil;
import com.theCoderKushagra.chatApp.Vixify.security.UserAuthentication;
import com.theCoderKushagra.chatApp.Vixify.service.EmailService;
import com.theCoderKushagra.chatApp.Vixify.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private OtpRedisCache otpRedis;
    @Autowired
    private UserRedis userRedis;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserAuthentication userAuthentication;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<String> SignUp(@RequestBody RequestUserDto users){
        try {
            String generatedOtp = userService.generateSixDigitNumber();
            String userName = users.getUserName();
            otpRedis.set(userName, generatedOtp, 600);
            userRedis.set("bringUserData", users, 600);
            // Sending male
            String email = users.getEmail();
            emailService.mailSender(email,
                    "OTP FOR EMAIL VARIFICATION",
                    "OTP: "+ generatedOtp + "\n\n" +
                            "Hi there,\nThe given 6-digit number is your varification otp for Sing-up.\n\nTEAM VIXIFY");
            return new ResponseEntity<>("Male sent successfully", HttpStatus.OK);
        }catch (Exception e){
            log.error("Error occur in public-SignUp",e);
            return new ResponseEntity<>("Unable to send mail.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/varify-otp")
    public ResponseEntity<?> otpVarify(@RequestBody VarifyUserDto varifyUser){
        try {
            String redisOtp = otpRedis.get(varifyUser.getUser());
            assert redisOtp != null;
            if (varifyUser.getOtp().equals(redisOtp)){
                Users users = userRedis.get("bringUserData", Users.class);
                userService.saveNewUser(users);
                userService.statusOffline(users);
                return new ResponseEntity<>("SingUp Successfully", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("SingUp Fail", HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Some error:", e);
            return new ResponseEntity<>("unable to save user data", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    @SendTo("/user/status")
    public ResponseEntity<?> login(@RequestBody Users user) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUserName(),
                            user.getPassword())
            );
            UserDetails userDetails = userAuthentication.loadUserByUsername(user.getUserName());
            String jwt = jwtUtil.generateToken(userDetails.getUsername());
            Map<String, String> response = new HashMap<>();
            response.put("token", jwt);
            userService.statusOnline(user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to SngIn: Incorrect Username or Password", HttpStatus.BAD_REQUEST);
        }
    }

}
