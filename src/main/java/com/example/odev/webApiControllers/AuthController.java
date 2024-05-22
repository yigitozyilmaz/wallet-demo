package com.example.odev.webApiControllers;

import com.example.odev.Entity.User;
import com.example.odev.Repository.UserRepository;
import com.example.odev.business.concretes.RegisterManager;
import com.example.odev.business.requests.LoginRequest;
import com.example.odev.business.requests.RegisterRequest;
import com.example.odev.business.responses.ErrorResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegisterManager registerManager;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            User user = userRepository.findUserByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
            if (user != null) {
                return ResponseEntity.ok("Login successful");
            } else {
                throw new BadCredentialsException("Invalid username or password");
            }
        } catch (BadCredentialsException badCredentialsException) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, "Hatalı şifre ya da kullanıcı adı");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse.getMessage());
        } catch (Exception exception) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        try {
            if (userRepository.existsByUsername(registerRequest.getUsername())) {
                ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, "Kullanıcı adı zaten var");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse.getMessage());
            }

            registerManager.saveUserToDB(registerRequest.getUsername(), registerRequest.getName(), registerRequest.getEmail(), registerRequest.getPassword());

            return ResponseEntity.ok("Registration successful");
        } catch (Exception exception) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse.getMessage());
        }
    }
}
