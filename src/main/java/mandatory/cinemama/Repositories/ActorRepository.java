package mandatory.cinemama.Repositories;

import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
  public List<Actor> findAll();

  public Optional<Actor> findById(Long id);

  public List<Actor> findByFirstName(String firstName);

  public List<Actor> findByLastName(String lastName);

  public Optional<Actor> findByFirstNameAndLastName(
    String firstName,
    String lastName
  );
}
