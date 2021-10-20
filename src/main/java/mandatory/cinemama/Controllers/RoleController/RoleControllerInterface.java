package mandatory.cinemama.Controllers.RoleController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.util.List;

import mandatory.cinemama.DTOs.RoleDTO;
import mandatory.cinemama.Entities.User.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(
  tags = "Roles",
  description = "- (OPTIONAL) A secured endpoint for <b>Roles</b>, requires a role of <b>ADMIN</b> to operate! - <em>(This endpoint was created for the testing and learning purposes only).</em>"
)
@RequestMapping("/api/roles")
public interface RoleControllerInterface {
  @ApiOperation(
    value = " - Returns all Roles available in the database",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Roles</b>."
  )
  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public List<Role> findAllRoles();

  @ApiOperation(
    value = " - Returns the Role by Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Role to retrieve a <b>Role</b> Object."
  )
  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public Role findRoleById(Long id);

  @ApiOperation(
    value = " - Returns the Role by Name",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Name</b> of a Role without the prefix 'ROLE_' to retrieve a <b>Role</b> Object."
  )
  @GetMapping("/name/{name}")
  @PreAuthorize("hasRole('ADMIN')")
  public RoleDTO findRoleByName(String name);
}
