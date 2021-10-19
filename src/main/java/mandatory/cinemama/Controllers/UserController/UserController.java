package mandatory.cinemama.Controllers.UserController;

import java.util.List;
import mandatory.cinemama.Entities.User.User;
import mandatory.cinemama.Services.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserControllerInterface {

  @Autowired
  private UserService userService;

  @Override
  public List<User> findAllUsers() {
    return userService.findAllUsers();
  }

  @Override
  public User findUserByEmail(String email) {
    return userService.findUserByEmail(email);
  }

  @Override
  public List<User> findUsersByRoleName(String role) {
    return userService.findUsersByRoleName(role);
  }

  @Override
  public Boolean userExistsByEmail(String email) {
    return userService.userExistsByEmail(email);
  }
}
