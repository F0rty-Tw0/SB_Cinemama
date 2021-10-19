package mandatory.cinemama.Repositories;

import java.util.List;
import java.util.Optional;

import mandatory.cinemama.Entities.User.ERoles;
import mandatory.cinemama.Entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  public Optional<User> findByEmail(String email);

  public List<User> findByRoleName(ERoles role);

  public Boolean existsByEmail(String email);
}
