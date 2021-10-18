package mandatory.cinemama.Repositories;

import java.util.Optional;
import mandatory.cinemama.Entities.Genre.EGenres;
import mandatory.cinemama.Entities.Genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
  public Optional<Genre> findById(Long id);

  public Optional<Genre> findByName(EGenres name);
}
