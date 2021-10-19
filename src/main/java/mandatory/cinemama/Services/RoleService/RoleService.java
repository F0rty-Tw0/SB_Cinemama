package mandatory.cinemama.Services.RoleService;

import java.util.List;
import mandatory.cinemama.Entities.User.Role;

public interface RoleService {
  public List<Role> findAllRoles();

  public Role findRoleById(Long id);

  public Role findRoleByName(String name);

  public void addRole(Role role);
}
