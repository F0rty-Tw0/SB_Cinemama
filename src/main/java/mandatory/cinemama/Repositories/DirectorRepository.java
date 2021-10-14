package mandatory.cinemama.Repositories;

import java.util.List;
import mandatory.cinemama.Entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
  public List<Director> findAll();

  public List<Director> findDirectorsByFirstName(String name);

  public List<Director> findDirectorsByLastName(String name);

  public void deleteDirectorById(Long id);
}
