package mandatory.cinemama.Configurations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.Entities.Director;
import mandatory.cinemama.Entities.Genre.EGenres;
import mandatory.cinemama.Entities.Genre.Genre;
import mandatory.cinemama.Entities.Hall.Hall;
import mandatory.cinemama.Entities.Hall.HallRow.ERows;
import mandatory.cinemama.Entities.Hall.HallRow.Row;
import mandatory.cinemama.Entities.Hall.Seat;
import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.Entities.Schedule;
import mandatory.cinemama.Entities.Theater;
import mandatory.cinemama.Entities.User.ERoles;
import mandatory.cinemama.Entities.User.Role;
import mandatory.cinemama.Entities.User.User;
import mandatory.cinemama.Repositories.ActorRepository;
import mandatory.cinemama.Repositories.DirectorRepository;
import mandatory.cinemama.Repositories.GenreRepository;
import mandatory.cinemama.Repositories.HallRepository;
import mandatory.cinemama.Repositories.MovieRepository;
import mandatory.cinemama.Repositories.RoleRepository;
import mandatory.cinemama.Repositories.RowRepository;
import mandatory.cinemama.Repositories.ScheduleRepository;
import mandatory.cinemama.Repositories.SeatRepository;
import mandatory.cinemama.Repositories.TheaterRepository;
import mandatory.cinemama.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class DatabaseConfig implements CommandLineRunner {

  @Autowired
  private DirectorRepository directorRepository;

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private HallRepository hallRepository;

  @Autowired
  private TheaterRepository theaterRepository;

  @Autowired
  private GenreRepository genreRepository;

  @Autowired
  private ActorRepository actorRepository;

  @Autowired
  private ScheduleRepository scheduleRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private RowRepository rowRepository;

  @Autowired
  private SeatRepository seatRepository;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("config runs");

    if (roleRepository.findAll().isEmpty()) {
      ERoles[] roles = ERoles.values();
      for (int i = 0; i < roles.length; i++) {
        roleRepository.save(new Role(roles[i]));
      }
    }

    if (userRepository.findAll().isEmpty()) {
      userRepository.save(
        new User("art@gmail.com", passwordEncoder.encode("test"))
      );
    }

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

    if (rowRepository.findAll().isEmpty()) {
      int numberOfHalls = hallRepository.findAll().size();
      ERows[] rows = ERows.values();
      for (int i = 0; i < numberOfHalls; i++) {
        for (int j = 0; j < rows.length; j++) {
          rowRepository.save(new Row(rows[j], hallRepository.findAll().get(i)));
        }
      }
    }

    if (seatRepository.findAll().isEmpty()) {
      int numberOfRows = rowRepository.findAll().size();
      for (int i = 0; i < numberOfRows; i++) {
        for (Integer j = 1; j < 6; j++) {
          seatRepository.save(
            new Seat(
              rowRepository.findAll().get(i).getName() + j.toString(),
              rowRepository.findAll().get(i)
            )
          );
        }
      }
    }
    if (directorRepository.findAll().isEmpty()) {
      directorRepository.save(new Director("Christopher", "Nolan"));
    }

    if (actorRepository.findAll().isEmpty()) {
      actorRepository.save(new Actor("Bruce", "Willis"));
    }

    if (genreRepository.findAll().isEmpty()) {
      EGenres[] genres = EGenres.values();
      for (int i = 0; i < genres.length; i++) {
        genreRepository.save(new Genre(genres[i]));
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
          actorRepository.findByFirstName("Bruce"),
          directorRepository.findByLastName("Nolan"),
          List.of(
            genreRepository.findByName(EGenres.ACTION).get(),
            genreRepository.findByName(EGenres.FANTASY).get(),
            genreRepository.findByName(EGenres.OTHER).get()
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
      scheduleRepository.save(
        new Schedule(
          LocalTime.of(14, 30),
          LocalDate.of(2021, Month.JANUARY, 25),
          movieRepository.findAll().get(0),
          hallRepository.findAll().get(0)
        )
      );
      scheduleRepository.save(
        new Schedule(
          LocalTime.of(14, 31),
          LocalDate.of(2021, Month.JANUARY, 24),
          movieRepository.findAll().get(0),
          hallRepository.findAll().get(0)
        )
      );
      scheduleRepository.save(
        new Schedule(
          LocalTime.of(14, 30),
          LocalDate.of(2021, Month.JANUARY, 24),
          movieRepository.findAll().get(0),
          hallRepository.findAll().get(3)
        )
      );
    }
  }
}
