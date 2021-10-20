package mandatory.cinemama.Controllers.RoleController;

import java.util.List;

import mandatory.cinemama.DTOs.RoleDTO;
import mandatory.cinemama.Entities.User.Role;
import mandatory.cinemama.Services.RoleService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController implements RoleControllerInterface {

  @Autowired
  private RoleService roleService;

  @Override
  public List<Role> findAllRoles() {
    return roleService.findAllRoles();
  }

  @Override
  public Role findRoleById(Long id) {
    return roleService.findRoleById(id);
  }

  @Override
  public RoleDTO findRoleByName(String name) {
    return roleService.findRoleByName(name);
  }
}
