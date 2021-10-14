package mandatory.cinemama.Configurations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.Entities.Director;
import mandatory.cinemama.Entities.Genre.EGenre;
import mandatory.cinemama.Entities.Genre.Genre;
import mandatory.cinemama.Entities.Hall;
import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.Entities.Schedule.Schedule;
import mandatory.cinemama.Entities.Theater;
import mandatory.cinemama.Repositories.ActorRepository;
import mandatory.cinemama.Repositories.DirectorRepository;
import mandatory.cinemama.Repositories.GenreRepository;
import mandatory.cinemama.Repositories.HallRepository;
import mandatory.cinemama.Repositories.MovieRepository;
import mandatory.cinemama.Repositories.ScheduleRepository;
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
  private ScheduleRepository scheduleRepository;

  public DatabaseConfiguration(
    DirectorRepository directorRepository,
    MovieRepository movieRepository,
    HallRepository hallRepository,
    TheaterRepository theaterRepository,
    GenreRepository genreRepository,
    ActorRepository actorRepository,
    ScheduleRepository scheduleRepository
  ) {
    this.movieRepository = movieRepository;
    this.directorRepository = directorRepository;
    this.hallRepository = hallRepository;
    this.theaterRepository = theaterRepository;
    this.genreRepository = genreRepository;
    this.actorRepository = actorRepository;
    this.scheduleRepository = scheduleRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("config runs");
    if (theaterRepository.findAll().isEmpty()) {
      theaterRepository.save(new Theater("Coco Bongo", "Gammel Konge Vej 6"));
      theaterRepository.save(new Theater("Odeon", "Saxogade 25"));
      theaterRepository.save(new Theater("IMAX 3D", "Dreams str 5"));
      theaterRepository.save(new Theater("Theater Lux", "Lala land 42"));
      theaterRepository.save(
        new Theater("Village Cinema", "Gammel Konge Vej 99")
      );
    }

    if (hallRepository.findAll().isEmpty()) {
      int numberOfTheaters = theaterRepository.findAll().size();
      for (int i = 0; i < numberOfTheaters; i++) {
        hallRepository.save(
          new Hall("Sal 1", theaterRepository.findAll().get(i))
        );
        hallRepository.save(
          new Hall("Sal 2", theaterRepository.findAll().get(i))
        );
        hallRepository.save(
          new Hall("Sal 3", theaterRepository.findAll().get(i))
        );
        hallRepository.save(
          new Hall("Sal 4", theaterRepository.findAll().get(i))
        );
        hallRepository.save(
          new Hall("Sal 5", theaterRepository.findAll().get(i))
        );
      }
    }

    if (directorRepository.findAll().isEmpty()) {
      directorRepository.save(new Director("Christopher", "Nolan"));
    }

    if (actorRepository.findAll().isEmpty()) {
      actorRepository.save(new Actor("Bruce", "Willis"));
    }

    if (genreRepository.findAll().isEmpty()) {
      EGenre[] genre = EGenre.values();
      for (int i = 0; i < genre.length; i++) {
        genreRepository.save(new Genre(genre[i]));
      }
    }

    if (movieRepository.findAll().isEmpty()) {
      movieRepository.save(
        new Movie(
          "Lord of the Rings 2",
          16,
          LocalTime.of(2, 30),
          "The Lord of the Rings is the saga of a group of sometimes reluctant heroes who set forth to save their world from consummate evil. Its many worlds and creatures were drawn from Tolkien's extensive knowledge of philology and folklore.",
          9,
          actorRepository.findActorsByFirstName("Bruce"),
          directorRepository.findDirectorsByLastName("Nolan"),
          List.of(
            genreRepository.findGenreByName(EGenre.ACTION).get(),
            genreRepository.findGenreByName(EGenre.FANTASY).get(),
            genreRepository.findGenreByName(EGenre.OTHER).get()
          )
        )
      );
    }

    if (scheduleRepository.findAll().isEmpty()) {
      scheduleRepository.save(
        new Schedule(
          LocalTime.of(14, 30),
          LocalDate.of(2021, Month.JANUARY, 24),
          movieRepository.findAll().get(0),
          hallRepository.findAll().get(0)
        )
      );
    }
  }
}
