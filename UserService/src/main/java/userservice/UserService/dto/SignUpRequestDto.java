package userservice.UserService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignUpRequestDto {
    private String username;
    private String password;
}
