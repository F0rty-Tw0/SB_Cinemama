package mandatory.cinemama.Repositories;

import mandatory.cinemama.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


    public Optional<Movie> findById(Long id);

    public void deleteMovieById(Long id);

    public List<Movie> findAll();

    public List<Movie> findMoviesByActor(String actor);

    public List<Movie> findMoviesByDirector(String director);

    public List<Movie> findMoviesByGenre(String genre);

    public Movie findMovieByTitle (String title);

}
