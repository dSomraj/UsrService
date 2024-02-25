package userservice.UserService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import userservice.UserService.dto.UserDto;

import javax.crypto.SecretKey;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import userservice.UserService.model.User;
import userservice.UserService.repository.UserRepository;

import java.util.Optional;

@Service
public class AuthService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private SecretKey secretKey;
    @Autowired
    public AuthService(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder){
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
        this.userRepository=userRepository;
        secretKey=Jwts.SIG.HS256.key().build();
    }
    public UserDto signup(String email, String password){
        Optional<User> userOptional=userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            throw new RuntimeException("User is already present");
        }
        User user=new User();
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        User savedUser=userRepository.save(user);
        UserDto userDto=UserDto.from(savedUser);
        return  userDto;
    }
    public UserDto login(String email, String password){
        Optional<User> userOptional=userRepository.findByEmail(email);
        if(!userOptional.isPresent()){
            throw new RuntimeException("User is already present");
        }


        return  null;
    }
}
