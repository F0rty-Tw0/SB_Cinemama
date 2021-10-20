package mandatory.cinemama.Services.RoleService;

import java.util.List;
import mandatory.cinemama.DTOs.RoleDTO;
import mandatory.cinemama.Entities.User.ERoles;
import mandatory.cinemama.Entities.User.Role;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.RoleRepository;
import mandatory.cinemama.Utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleRepository roleRepository;

  private String type = "Role";

  @Override
  public List<Role> findAllRoles() {
    List<Role> allRoles = roleRepository.findAll();
    return allRoles;
  }

  @Override
  public Role findRoleById(Long id) {
    Role role = roleRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    return role;
  }

  @Override
  public RoleDTO findRoleByName(String name) {
    String roleName = "ROLE_" + name.toUpperCase();
    try {
      Role role = roleRepository.findByName(ERoles.valueOf(roleName)).get();
      return DTOConverter.mapDTO(role, RoleDTO.class);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(
        ErrorMessageCreator.NotFoundErrorMessage(name, type)
      );
    }
  }

  @Override
  public void addRole(Role role) {
    roleRepository.save(role);
  }
}
