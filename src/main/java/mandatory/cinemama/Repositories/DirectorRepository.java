package mandatory.cinemama.Repositories;

import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
  public List<Director> findAll();

  public Optional<Director> findById(Long id);

  public List<Director> findByFirstName(String firstName);

  public List<Director> findByLastName(String lastName);

  public Director findByFirstNameAndLastName(
    String firstName,
    String lastName
  );
}
