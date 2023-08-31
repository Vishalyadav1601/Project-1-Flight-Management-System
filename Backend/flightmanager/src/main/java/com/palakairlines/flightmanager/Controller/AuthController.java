package com.palakairlines.flightmanager.Controller;

import com.palakairlines.flightmanager.DTO.JWTRequest;
import com.palakairlines.flightmanager.DTO.JWTResponse;
import com.palakairlines.flightmanager.DTO.UserDTO;
import com.palakairlines.flightmanager.Exceptions.ApiException;
import com.palakairlines.flightmanager.Security.JWTTokenHelper;
import com.palakairlines.flightmanager.Service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTTokenHelper jwtTokenHelper;
    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login(@Valid @RequestBody JWTRequest request)
    {
        this.doAuthenticate(request.getUserName(),request.getUserPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
        String token = this.jwtTokenHelper.generateToken(userDetails);

        JWTResponse response = JWTResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @PostMapping("/loginAdmin")
    public ResponseEntity<JWTResponse> loginAdmin(@Valid @RequestBody JWTRequest request)
    {
        this.doAuthenticate(request.getUserName(),request.getUserPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
        String token = this.jwtTokenHelper.generateToken(userDetails);

        JWTResponse response = JWTResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String userName,String userPassword)
    {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName,userPassword);
        try{
            authenticationManager.authenticate(authenticationToken);
        }
        catch(BadCredentialsException e)
        {
            throw new ApiException("Invalid Username or Password!!");
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler()
    {
        return "Credentials Invalid!!";
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser (@Valid @RequestBody UserDTO userDTO)
    {
        UserDTO registeredUser = this.userService.registerUser(userDTO);

        return new ResponseEntity<UserDTO>(registeredUser,HttpStatus.CREATED);
    }

    @PostMapping("/registerAdmin")
    public ResponseEntity<UserDTO> registerAdmin (@Valid @RequestBody UserDTO userDTO)
    {
        UserDTO registeredUser = this.userService.registerAdmin(userDTO);

        return new ResponseEntity<UserDTO>(registeredUser,HttpStatus.CREATED);
    }


}
