package mandatory.cinemama.Repositories;

import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
  public List<Movie> findAll();

  public Optional<Movie> findByTitle(String title);

  public Optional<Movie> findById(Long id);

  public void deleteById(Long id);
}
