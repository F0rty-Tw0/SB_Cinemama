package mandatory.cinemama.Repositories;

import java.util.List;
import mandatory.cinemama.Entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
  public List<Director> findAll();

  public List<Director> findByFirstName(String name);

  public List<Director> findByLastName(String name);
}
