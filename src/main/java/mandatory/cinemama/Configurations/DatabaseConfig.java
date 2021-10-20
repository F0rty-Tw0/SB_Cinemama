package mandatory.cinemama.Configurations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
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
import mandatory.cinemama.Security.AuthenticationPayload.Request.SignupRequest;
import mandatory.cinemama.Services.ActorService.ActorService;
import mandatory.cinemama.Services.AuthService.AuthService;
import mandatory.cinemama.Services.DirectorService.DirectorService;
import mandatory.cinemama.Services.GenreService.GenreService;
import mandatory.cinemama.Services.HallService.HallService;
import mandatory.cinemama.Services.MovieService.MovieService;
import mandatory.cinemama.Services.RoleService.RoleService;
import mandatory.cinemama.Services.RowService.RowService;
import mandatory.cinemama.Services.ScheduleService.ScheduleService;
import mandatory.cinemama.Services.SeatService.SeatService;
import mandatory.cinemama.Services.TheaterService.TheaterService;
import mandatory.cinemama.Services.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class DatabaseConfig implements CommandLineRunner {

  @Autowired
  private DirectorService directorService;

  @Autowired
  private MovieService movieService;

  @Autowired
  private HallService hallService;

  @Autowired
  private TheaterService theaterService;

  @Autowired
  private GenreService genreService;

  @Autowired
  private ActorService actorService;

  @Autowired
  private ScheduleService scheduleService;

  @Autowired
  private RoleService roleService;

  @Autowired
  private UserService userService;

  @Autowired
  private AuthService authService;

  @Autowired
  private RowService rowService;

  @Autowired
  private SeatService seatService;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("config runs");

    if (roleService.findAllRoles().isEmpty()) {
      ERoles[] roles = ERoles.values();
      for (int i = 0; i < roles.length; i++) {
        roleService.addRole(new Role(roles[i]));
      }
    }

    if (userService.findAllUsers().isEmpty()) {
      authService.registerUser(
        new SignupRequest("art@gmail.com", "admin", "test")
      );
    }

    if (theaterService.findAllTheaters().isEmpty()) {
      theaterService.addTheater(new Theater("Odeon", "Saxogade 25"));
      theaterService.addTheater(
        new Theater("Village Cinema", "Gammel Konge Vej 99")
      );
      // theaterService.addTheater(
      //   new Theater("Coco Bongo", "Gammel Konge Vej 6")
      // );
      // theaterService.addTheater(new Theater("IMAX 3D", "Dreams str 5"));
      // theaterService.addTheater(new Theater("Theater Lux", "Lala land 42"));
    }

    if (hallService.findAllHalls().isEmpty()) {
      int numberOfTheaters = theaterService.findAllTheaters().size();
      for (int i = 0; i < numberOfTheaters; i++) {
        hallService.addHall(
          new Hall("Sal 1", theaterService.findAllTheaters().get(i))
        );
        hallService.addHall(
          new Hall("Sal 2", theaterService.findAllTheaters().get(i))
        );
        // hallService.addHall(
        //   new Hall("Sal 3", theaterService.findAllTheaters().get(i))
        // );
        // hallService.addHall(
        //   new Hall("Sal 4", theaterService.findAllTheaters().get(i))
        // );
        // hallService.addHall(
        //   new Hall("Sal 5", theaterService.findAllTheaters().get(i))
        // );
      }
    }

    if (rowService.findAllRows().isEmpty()) {
      int numberOfHalls = hallService.findAllHalls().size();
      ERows[] rows = ERows.values();
      for (int i = 0; i < numberOfHalls; i++) {
        for (int j = 0; j < rows.length; j++) {
          rowService.addRow(
            new Row(rows[j], hallService.findAllHalls().get(i))
          );
        }
      }
    }

    if (seatService.findAllSeats().isEmpty()) {
      int numberOfRows = rowService.findAllRows().size();
      for (int i = 0; i < numberOfRows; i++) {
        for (Integer j = 1; j < 6; j++) {
          if (j < 5) {
            seatService.addSeat(
              new Seat(
                rowService.findAllRows().get(i).getName() + j.toString(),
                rowService.findAllRows().get(i),
                true
              )
            );
          } else {
            seatService.addSeat(
              new Seat(
                rowService.findAllRows().get(i).getName() + j.toString(),
                rowService.findAllRows().get(i),
                false
              )
            );
          }
        }
      }
    }
    if (directorService.findAllDirectors().isEmpty()) {
      directorService.addDirector(new Director("Peter Jackson"));
    }

    if (actorService.findAllActors().isEmpty()) {
      actorService.addActor(new Actor("Elijah Wood"));
      actorService.addActor(new Actor("Ian McKellen"));
      actorService.addActor(new Actor("Liv Tyler"));
      actorService.addActor(new Actor("Viggo Mortensen"));
    }

    if (genreService.findAllGenres().isEmpty()) {
      EGenres[] genres = EGenres.values();
      for (int i = 0; i < genres.length; i++) {
        genreService.addGenre(new Genre(genres[i]));
      }
    }

    if (movieService.findAllMovies().isEmpty()) {
      movieService.addMovie(
        new Movie(
          "Lord of the Rings: The Two Towers",
          11,
          LocalTime.of(2, 59),
          "Frodo and Sam are trekking to Mordor to destroy the One Ring of Power while Gimli, Legolas and Aragorn search for the orc-captured Merry and Pippin. All along, nefarious wizard Saruman awaits the Fellowship members at the Orthanc Tower in Isengard.",
          8.7d,
          new ArrayList<Actor>(
            Arrays.asList(
              actorService.findActorsByNameContaining("Elijah Wood").get(0),
              actorService.findActorsByNameContaining("Ian McKellen").get(0),
              actorService.findActorsByNameContaining("Liv Tyler").get(0),
              actorService.findActorsByNameContaining("Viggo Mortensen").get(0)
            )
          ),
          directorService.findDirectorsByNameContaining("Peter Jackson"),
          List.of(
            genreService.findGenreByName("ADVENTURE"),
            genreService.findGenreByName("FANTASY"),
            genreService.findGenreByName("ACTION")
          ),
          "LbfMDwc4azU",
          // https://www.youtu.be/<TRAILER ID>
          "5VTN0pR8gcqV3EPUHHfMGnJYN9L.jpg",
          // https://www.themoviedb.org/t/p/original/<POSTER ID>
          "121-the-lord-of-the-rings-the-two-towers"
          // https://www.themoviedb.org/movie/<ID OF THE IMAGES>/images/backdrops
        )
      );
    }

    if (scheduleService.findAllSchedules().isEmpty()) {
      scheduleService.addSchedule(
        new Schedule(
          LocalTime.of(14, 30),
          LocalDate.of(2021, Month.JANUARY, 24),
          movieService.findAllMovies().get(0),
          hallService.findAllHalls().get(0)
        )
      );
      scheduleService.addSchedule(
        new Schedule(
          LocalTime.of(14, 30),
          LocalDate.of(2021, Month.JANUARY, 25),
          movieService.findAllMovies().get(0),
          hallService.findAllHalls().get(0)
        )
      );
      scheduleService.addSchedule(
        new Schedule(
          LocalTime.of(14, 31),
          LocalDate.of(2021, Month.JANUARY, 24),
          movieService.findAllMovies().get(0),
          hallService.findAllHalls().get(0)
        )
      );
      scheduleService.addSchedule(
        new Schedule(
          LocalTime.of(14, 30),
          LocalDate.of(2021, Month.JANUARY, 24),
          movieService.findAllMovies().get(0),
          hallService.findAllHalls().get(3)
        )
      );
    }
  }
}
