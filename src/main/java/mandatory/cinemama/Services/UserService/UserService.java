package mandatory.cinemama.Services.UserService;

import java.util.List;
import mandatory.cinemama.Entities.User.User;

public interface UserService {
  public List<User> findAllUsers();

  public User findUserByEmail(String email, boolean isExtended);

  public List<User> findUsersByRoleName(String role);

  public Boolean userExistsByEmail(String email);

  public void addUser(User user);
}
