package mandatory.cinemama.Controllers.UserController;

import java.util.List;
import mandatory.cinemama.Entities.User.User;
import mandatory.cinemama.Security.JWT.JwtUtils;
import mandatory.cinemama.Services.UserService.UserService;
import mandatory.cinemama.Utils.CheckExtended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserControllerInterface {

  @Autowired
  private UserService userService;

  @Autowired
  JwtUtils jwtUtils;

  @Override
  public List<User> findAllUsers() {
    return userService.findAllUsers();
  }

  @Override
  public Object findUserByEmail(String email, String type) {
    return userService.findUserByEmail(email, CheckExtended.isExtended(type));
  }

  @Override
  public Object getUserFromToken(String token, String type) {
    String email = jwtUtils.getUserNameFromJwtToken(token.substring(7));
    return userService.findUserByEmail(email, CheckExtended.isExtended(type));
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
