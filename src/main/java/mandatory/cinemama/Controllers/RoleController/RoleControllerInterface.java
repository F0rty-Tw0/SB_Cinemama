package mandatory.cinemama.Controllers.RoleController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import mandatory.cinemama.Entities.User.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "Roles")
@RequestMapping("/api/roles")
public interface RoleControllerInterface {
  @ApiOperation("Returns all Roles available in the database")
  @GetMapping
  public List<Role> findAllRoles();

  @ApiOperation("Returns the Role by Id")
  @GetMapping("/{id}")
  public Role findRoleById(Long id);

  @ApiOperation("Returns the Role by Name")
  @GetMapping("/name/{name}")
  public Role findRoleByName(String name);
}
