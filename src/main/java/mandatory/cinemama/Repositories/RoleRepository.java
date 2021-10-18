package mandatory.cinemama.Repositories;

import mandatory.cinemama.Entities.User.ERoles;
import mandatory.cinemama.Entities.User.Role;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  public Optional<Role> findByName(ERoles name);
}
