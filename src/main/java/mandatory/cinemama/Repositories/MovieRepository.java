package mandatory.cinemama.Repositories;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import mandatory.cinemama.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
  public List<Movie> findByInfoContaining(String info);

  public List<Movie> findByMinAgeLessThan(int minAge);

  public List<Movie> findByMinAgeGreaterThan(int minAge);

  public List<Movie> findByRating(int rating);

  public List<Movie> findByScreenTimeLessThan(LocalTime screenTime);

  public List<Movie> findByScreenTimeGreaterThan(LocalTime screenTime);

  public Optional<Movie> findByTitle(String title);

  public Optional<Movie> findById(Long id);

  public List<Movie> findInfoByTitleContaining(String title);
}
