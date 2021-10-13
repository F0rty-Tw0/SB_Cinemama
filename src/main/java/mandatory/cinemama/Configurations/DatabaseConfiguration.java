package mandatory.cinemama.Configurations;

import java.time.LocalTime;
import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.Entities.Director;
import mandatory.cinemama.Entities.Genre.EGenre;
import mandatory.cinemama.Entities.Genre.Genre;
import mandatory.cinemama.Entities.Hall;
import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.Entities.Theater;
import mandatory.cinemama.Repositories.ActorRepository;
import mandatory.cinemama.Repositories.DirectorRepository;
import mandatory.cinemama.Repositories.GenreRepository;
import mandatory.cinemama.Repositories.HallRepository;
import mandatory.cinemama.Repositories.MovieRepository;
import mandatory.cinemama.Repositories.TheaterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class DatabaseConfiguration implements CommandLineRunner {

  private DirectorRepository directorRepository;
  private MovieRepository movieRepository;
  private HallRepository hallRepository;
  private TheaterRepository theaterRepository;
  private GenreRepository genreRepository;
  private ActorRepository actorRepository;

  public DatabaseConfiguration(
    DirectorRepository directorRepository,
    MovieRepository movieRepository,
    HallRepository hallRepository,
    TheaterRepository theaterRepository,
    GenreRepository genreRepository,
    ActorRepository actorRepository
  ) {
    // TODO: Add repositories
    this.movieRepository = movieRepository;
    this.directorRepository = directorRepository;
    this.hallRepository = hallRepository;
    this.theaterRepository = theaterRepository;
    this.genreRepository = genreRepository;
    this.actorRepository = actorRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("config runs");
    if (
      directorRepository.findDirectorsByFirstName("Christopher").size() == 0
    ) {
      directorRepository.save(new Director("Christopher", "Nolan"));
    }

    if (actorRepository.findActorsByFirstName("Bruce").size() == 0) {
      actorRepository.save(new Actor("Bruce", "Willis"));
    }

    if (genreRepository.findAll().size() == 0) {
      EGenre[] genre = EGenre.values();
      for (int i = 0; i < genre.length; i++) {
        genreRepository.save(new Genre(genre[i]));
      }
    }
    if (!theaterRepository.findTheaterByName("Coco Bongo").isPresent()) {
      theaterRepository.save(new Theater("Coco Bongo", "Gammel Konge Vej 6"));
    }

    if (!hallRepository.findHallByName("Sal 1").isPresent()) {
      hallRepository.save(new Hall("Sal 1"));
    }

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
