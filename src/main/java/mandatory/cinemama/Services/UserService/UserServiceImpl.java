package mandatory.cinemama.Services.UserService;

import java.util.List;
import mandatory.cinemama.DTOs.UserDTO;
import mandatory.cinemama.Entities.User.ERoles;
import mandatory.cinemama.Entities.User.User;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.UserRepository;
import mandatory.cinemama.Utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  private String type = "User";

  @Override
  public List<User> findAllUsers() {
    List<User> allUsers = userRepository.findAll();
    return allUsers;
  }

  @Override
  public User findUserByEmail(String email, boolean isExtended) {
    User user = userRepository
      .findByEmail(email)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(email, type)
          )
      );
    if (!isExtended) {
      UserDTO userDTO = DTOConverter.mapDTO(user, UserDTO.class);
      user = DTOConverter.mapDTO(userDTO, User.class);
    }
    return user;
  }

  @Override
  public List<User> findUsersByRoleName(String role) {
    List<User> users = userRepository.findByRoleName(
      ERoles.valueOf(role.toUpperCase())
    );
    ErrorMessageCreator.throwErrorIfNotFound(users, role, type);
    return users;
  }

  @Override
  public Boolean userExistsByEmail(String email) {
    Boolean exists = userRepository.existsByEmail(email);
    return exists;
  }

  @Override
  public void addUser(User user) {
    userRepository.save(user);
  }
}
