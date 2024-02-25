package userservice.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userservice.UserService.dto.LoginRequestDto;
import userservice.UserService.dto.SignUpRequestDto;
import userservice.UserService.dto.UserDto;
import userservice.UserService.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;
    @Autowired
    public AuthController(AuthService authService){
        this.authService=authService;
    }
    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody SignUpRequestDto signUpRequestDto){
        UserDto userDto=authService.signup(signUpRequestDto.getUsername(), signUpRequestDto.getPassword());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto loginRequestDto){
        UserDto userDto=authService.login(loginRequestDto.getUsername(),loginRequestDto.getPassword());
        return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
    }
    @GetMapping("/hello")
    public String printer(){
        System.out.println("Hello World");
        return "Hello World";
    }
}
