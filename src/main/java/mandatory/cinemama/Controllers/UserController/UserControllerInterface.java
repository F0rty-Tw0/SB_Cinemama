package mandatory.cinemama.Controllers.UserController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;

import mandatory.cinemama.Entities.User.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "Users")
@RequestMapping("/api/users")
public interface UserControllerInterface {
  //TODO: MUST HAVE DTO TO HIDE THE PASSWORD!!!
  @ApiOperation("Returns all Users available in the database")
  @GetMapping
  public List<User> findAllUsers();

  @ApiOperation("Returns the User by Email")
  @GetMapping("/email/{email}")
  public User findUserByEmail(String email);

  @ApiOperation("Returns the User by Role")
  @GetMapping("/role/{role}")
  public List<User> findUsersByRoleName(String role);

  @ApiOperation("Checks if the User exists with the Email")
  @GetMapping("/exists/{email}")
  public Boolean userExistsByEmail(String email);
}
