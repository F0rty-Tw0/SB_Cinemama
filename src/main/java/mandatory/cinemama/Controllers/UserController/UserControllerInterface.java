package mandatory.cinemama.Controllers.UserController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.util.List;
import mandatory.cinemama.Entities.User.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(
  tags = "Users (OPTIONAL)",
  description = "- A secured endpoint for <b>Users</b>, requires a role of <b>ADMIN</b> to operate! - <em>(This endpoint was created for the testing and learning purposes only).</em>"
)
@RequestMapping("/api/users")
public interface UserControllerInterface {
  //TODO: MUST HAVE DTO TO HIDE THE PASSWORD!!!
  @ApiOperation(
    value = " - Returns all Users available in the database",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Users</b>."
  )
  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public List<User> findAllUsers();

  @ApiOperation(
    value = " - Returns the User by Email",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Email</b> of a User to retrieve an <b>User</b> Object."
  )
  @GetMapping("/email/{email}")
  @PreAuthorize("hasRole('ADMIN')")
  public User findUserByEmail(String email);

  @ApiOperation(
    value = " - Returns the User by Role",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Role</b> of a User to retrieve an <b>User</b> Object."
  )
  @GetMapping("/role/{role}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<User> findUsersByRoleName(String role);

  @ApiOperation(
    value = " - Checks if the User exists with the Email",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Email</b> of a User to to check if User exists."
  )
  @GetMapping("/exists/{email}")
  @PreAuthorize("hasRole('ADMIN')")
  public Boolean userExistsByEmail(String email);
}
