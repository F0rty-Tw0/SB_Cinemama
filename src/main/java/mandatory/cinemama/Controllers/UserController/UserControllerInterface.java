package mandatory.cinemama.Controllers.UserController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.util.List;
import mandatory.cinemama.Entities.User.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(
  tags = "Users",
  description = "- (OPTIONAL) A secured endpoint for <b>Users</b>, requires a role of <b>ADMIN, MANAGER, CUSTOMER</b> to operate! - <em>(This endpoint was created for the testing and learning purposes only).</em>"
)
@RequestMapping("/api/users")
public interface UserControllerInterface {
  @ApiOperation(
    value = " - Returns all Users available in the database",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Users</b>."
  )
  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public List<User> findAllUsers();

  @ApiOperation(
    value = " - Returns the User by Email ('type=extended' - extends the returned data - Requires ADMIN rights)",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Email</b> of a User to retrieve an <b>User</b> Object.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @GetMapping("/email/{email}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public Object findUserByEmail(
    @PathVariable String email,
    @RequestParam(required = false) String type
  );

  @ApiOperation(
    value = " - Returns the authenticated user ('type=extended' - extends the returned data - Requires ADMIN rights)",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Retrieve an <b>User</b> Object.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @GetMapping("/user")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public Object getUserFromToken(
    @RequestHeader(name="Authorization", required = false) String token,
    @RequestParam(required = false) String type
  );

  @ApiOperation(
    value = " - Returns the User by Role",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Role</b> of a User to retrieve an <b>User</b> Object."
  )
  @GetMapping("/role/{role}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<User> findUsersByRoleName(@PathVariable String role);

  @ApiOperation(
    value = " - Checks if the User exists with the Email",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Email</b> of a User to to check if User exists."
  )
  @GetMapping("/exists/{email}")
  @PreAuthorize("hasRole('ADMIN')")
  public Boolean userExistsByEmail(@PathVariable String email);
}
