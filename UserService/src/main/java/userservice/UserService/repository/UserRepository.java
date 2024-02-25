package userservice.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import userservice.UserService.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findByEmail(String username);
    public User save(User user);

}
