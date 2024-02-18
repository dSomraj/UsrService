package userservice.UserService.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class User extends BaseModel{
    private String email;
    private String password;
    private List<Role> roles;
}
