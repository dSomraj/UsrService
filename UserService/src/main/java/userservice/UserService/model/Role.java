package userservice.UserService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Role extends BaseModel{
    private String role;
}
