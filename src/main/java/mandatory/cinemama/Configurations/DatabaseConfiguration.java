package mandatory.cinemama.Configurations;

import java.time.LocalTime;
import mandatory.cinemama.Entities.Director;
import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.Repositories.DirectorRepository;
import mandatory.cinemama.Repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class DatabaseConfiguration implements CommandLineRunner {

  private DirectorRepository directorRepository;
  private MovieRepository movieRepository;

  public DatabaseConfiguration(
    DirectorRepository directorRepository,
    MovieRepository movieRepository
  ) {
    // TODO: Add repositories
    this.movieRepository = movieRepository;
    this.directorRepository = directorRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("config runs");
    directorRepository.save(new Director("John", "Smith"));
    if (!movieRepository.findMovieByTitle("Lord of the Rings 2").isPresent()) {
      movieRepository.save(
        new Movie(
          "Lord of the Rings 2",
          16,
          LocalTime.of(2, 30),
          "The Lord of the Rings is the saga of a group of sometimes reluctant heroes who set forth to save their world from consummate evil. Its many worlds and creatures were drawn from Tolkien's extensive knowledge of philology and folklore.",
          9
        )
      );
    }
    // TODO: Setup data to database
  }
}
