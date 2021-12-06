package mandatory.cinemama.Configurations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.Set;
import mandatory.cinemama.DTOs.ActorDTO;
import mandatory.cinemama.DTOs.DirectorDTO;
import mandatory.cinemama.DTOs.ImputDTOs.ActorInputDTO;
import mandatory.cinemama.DTOs.ImputDTOs.DirectorInputDTO;
import mandatory.cinemama.DTOs.ImputDTOs.GenreInputDTO;
import mandatory.cinemama.DTOs.ImputDTOs.HallInputDTO;
import mandatory.cinemama.DTOs.ImputDTOs.MovieInputDTO;
import mandatory.cinemama.DTOs.ImputDTOs.ReservationInputDTO;
import mandatory.cinemama.DTOs.ImputDTOs.ReservationScheduleInputDTO;
import mandatory.cinemama.DTOs.ImputDTOs.ScheduleHallInputDTO;
import mandatory.cinemama.DTOs.ImputDTOs.ScheduleInputDTO;
import mandatory.cinemama.DTOs.ImputDTOs.ScheduleMovieInputDTO;
import mandatory.cinemama.DTOs.ImputDTOs.SeatInputDTO;
import mandatory.cinemama.DTOs.ImputDTOs.TheaterInputDTO;
import mandatory.cinemama.DTOs.ImputDTOs.UserInputDTO;
import mandatory.cinemama.DTOs.TheaterDTO;
import mandatory.cinemama.Entities.Genre.EGenres;
import mandatory.cinemama.Entities.Genre.Genre;
import mandatory.cinemama.Entities.Hall.HallRow.ERows;
import mandatory.cinemama.Entities.Hall.HallRow.Row;
import mandatory.cinemama.Entities.Hall.Seat;
import mandatory.cinemama.Entities.User.ERoles;
import mandatory.cinemama.Entities.User.Role;
import mandatory.cinemama.Security.AuthenticationPayload.Request.SignupRequest;
import mandatory.cinemama.Services.ActorService.ActorService;
import mandatory.cinemama.Services.AuthService.AuthService;
import mandatory.cinemama.Services.DirectorService.DirectorService;
import mandatory.cinemama.Services.GenreService.GenreService;
import mandatory.cinemama.Services.HallService.HallService;
import mandatory.cinemama.Services.MovieService.MovieService;
import mandatory.cinemama.Services.ReservationService.ReservationService;
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

  @Autowired
  private ReservationService reservationService;

  @Override
  public void run(String... args) throws Exception {
    // NOTE:THIS DATA SHOULD NOT BE HERE, IT IS ONLY FOR TEST PURPOSES
    System.out.println(
      "GENERATING DEFAULT VALUES IF NOT EXISTS !! THIS IS FOR TEST PURPOSES"
    );
    // NOTE: GENERATING ROLES
    if (roleService.findAllRoles().isEmpty()) {
      ERoles[] roles = ERoles.values();
      for (int i = 0; i < roles.length; i++) {
        roleService.addRole(new Role(roles[i]));
      }
    }

    // NOTE: GENERATING USERS
    if (userService.findAllUsers().isEmpty()) {
      authService.registerUser(
        new SignupRequest("art@gmail.com", "admin", "test")
      );
      authService.registerUser(
        new SignupRequest("customer2@gmail.com", "customer", "test")
      );
      authService.registerUser(
        new SignupRequest("customer1@gmail.com", "customer", "test")
      );
      authService.registerUser(
        new SignupRequest("admin@gmail.com", "admin", "test")
      );
      authService.registerUser(
        new SignupRequest("manager@gmail.com", "manager", "test")
      );
    }

    // NOTE: GENERATING THEATERS
    if (theaterService.findAllTheaters(false).isEmpty()) {
      theaterService.addTheater(new TheaterDTO("Odeon", "Saxogade 25"));
      theaterService.addTheater(
        new TheaterDTO("Village Cinema", "Gammel Konge Vej 99")
      );
    }

    // NOTE: GENERATING HALLS FOR EACH THEATER
    if (hallService.findAllHalls().isEmpty()) {
      int numberOfTheaters = theaterService.findAllTheaters(false).size();
      for (long i = 1; i < numberOfTheaters + 1; i++) {
        hallService.addHall(new HallInputDTO("Sal 1", new TheaterInputDTO(i)));
        hallService.addHall(new HallInputDTO("Sal 2", new TheaterInputDTO(i)));
        hallService.addHall(new HallInputDTO("Sal 3", new TheaterInputDTO(i)));
      }
    }

    // NOTE: GENERATING ROWS FOR EACH HALL
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

    // NOTE: GENERATING SEATS FOR EACH ROW
    if (seatService.findAllSeats().isEmpty()) {
      int numberOfRows = rowService.findAllRows().size();
      for (int i = 0; i < numberOfRows; i++) {
        for (Integer j = 1; j < 6; j++) {
          seatService.addSeat(
            new Seat(
              rowService.findAllRows().get(i).getName() + j.toString(),
              rowService.findAllRows().get(i)
            )
          );
        }
      }
    }

    // NOTE: GENERATING GENRES
    if (genreService.findAllGenres().isEmpty()) {
      EGenres[] genres = EGenres.values();
      for (int i = 0; i < genres.length; i++) {
        genreService.addGenre(new Genre(genres[i]));
      }
    }

    // NOTE: GENERATING DIRECTORS
    if (directorService.findAllDirectors().isEmpty()) {
      directorService.addDirector(new DirectorDTO("Peter Jackson"));
      directorService.addDirector(new DirectorDTO("Christopher Nolan"));
      directorService.addDirector(new DirectorDTO("Steven Spielberg"));
      directorService.addDirector(new DirectorDTO("Quentin Tarantino"));
      directorService.addDirector(new DirectorDTO("David Lynch"));
    }

    // NOTE: GENERATING ACTORS
    if (actorService.findAllActors().isEmpty()) {
      actorService.addActor(new ActorDTO("Elijah Wood"));
      actorService.addActor(new ActorDTO("Ian McKellen"));
      actorService.addActor(new ActorDTO("Liv Tyler"));
      actorService.addActor(new ActorDTO("Viggo Mortensen"));
      actorService.addActor(new ActorDTO("Matthew McConaughey"));
      actorService.addActor(new ActorDTO("Anne Hathaway"));
      actorService.addActor(new ActorDTO("Jessica Chastain"));
      actorService.addActor(new ActorDTO("Ellen Burstyn"));
      actorService.addActor(new ActorDTO("John Lithgow"));
    }

    // NOTE: GENERATING MOVIES
    if (movieService.findAllMovies(true).isEmpty()) {
      movieService.addMovie(
        new MovieInputDTO(
          "Lord of the Rings: The Two Towers",
          11L,
          LocalTime.of(2, 59),
          "Frodo and Sam are trekking to Mordor to destroy the One Ring of Power while Gimli, Legolas and Aragorn search for the orc-captured Merry and Pippin. All along, nefarious wizard Saruman awaits the Fellowship members at the Orthanc Tower in Isengard.",
          8.7d,
          "LbfMDwc4azU",
          // https://www.youtu.be/<TRAILER_ID>
          "5VTN0pR8gcqV3EPUHHfMGnJYN9L.jpg",
          // https://www.themoviedb.org/t/p/original/<POSTER_ID>
          "121-the-lord-of-the-rings-the-two-towers",
          // https://www.themoviedb.org/movie/<IMAGES_ID>/images/backdrops
          Set.of(
            new GenreInputDTO(
              genreService.findGenreByName("ADVENTURE").getId()
            ),
            new GenreInputDTO(genreService.findGenreByName("FANTASY").getId()),
            new GenreInputDTO(genreService.findGenreByName("ACTION").getId())
          ),
          Set.of(
            new ActorInputDTO(
              actorService
                .findActorsByNameContaining("Elijah Wood", true)
                .get(0)
                .getId()
            ),
            new ActorInputDTO(
              actorService
                .findActorsByNameContaining("Ian McKellen", true)
                .get(0)
                .getId()
            ),
            new ActorInputDTO(
              actorService
                .findActorsByNameContaining("Liv Tyler", true)
                .get(0)
                .getId()
            ),
            new ActorInputDTO(
              actorService
                .findActorsByNameContaining("Viggo Mortensen", true)
                .get(0)
                .getId()
            )
          ),
          Set.of(
            new DirectorInputDTO(
              directorService
                .findDirectorsByNameContaining("Peter Jackson", true)
                .get(0)
                .getId()
            )
          )
        )
      );
      movieService.addMovie(
        new MovieInputDTO(
          "Interstellar ",
          11L,
          LocalTime.of(2, 59),
          "The adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.",
          8.6d,
          "827FNDpQWrQ",
          // https://www.youtu.be/<TRAILER_ID>
          "gEU2QniE6E77NI6lCU6MxlNBvIx.jpg",
          // https://www.themoviedb.org/t/p/original/<POSTER_ID>
          "157336-interstellar",
          // https://www.themoviedb.org/movie/<IMAGES_ID>/images/backdrops
          Set.of(
            new GenreInputDTO(
              genreService.findGenreByName("ADVENTURE").getId()
            ),
            new GenreInputDTO(genreService.findGenreByName("DRAMA").getId()),
            new GenreInputDTO(genreService.findGenreByName("SCI_FI").getId())
          ),
          Set.of(
            new ActorInputDTO(
              actorService
                .findActorsByNameContaining("Matthew McConaughey", true)
                .get(0)
                .getId()
            ),
            new ActorInputDTO(
              actorService
                .findActorsByNameContaining("Anne Hathaway", true)
                .get(0)
                .getId()
            ),
            new ActorInputDTO(
              actorService
                .findActorsByNameContaining("Jessica Chastain", true)
                .get(0)
                .getId()
            ),
            new ActorInputDTO(
              actorService
                .findActorsByNameContaining("Ellen Burstyn", true)
                .get(0)
                .getId()
            ),
            new ActorInputDTO(
              actorService
                .findActorsByNameContaining("John Lithgow", true)
                .get(0)
                .getId()
            )
          ),
          Set.of(
            new DirectorInputDTO(
              directorService
                .findDirectorsByNameContaining("Christopher Nolan", true)
                .get(0)
                .getId()
            )
          )
        )
      );
    }

    // NOTE: GENERATING SCHEDULES
    if (scheduleService.findAllSchedules().isEmpty()) {
      scheduleService.addSchedule(
        new ScheduleInputDTO(
          LocalDate.of(2021, Month.OCTOBER, 23),
          LocalTime.of(14, 30),
          new ScheduleHallInputDTO(1l),
          new ScheduleMovieInputDTO(1l)
        )
      );
      scheduleService.addSchedule(
        new ScheduleInputDTO(
          LocalDate.of(2021, Month.OCTOBER, 23),
          LocalTime.of(17, 30),
          new ScheduleHallInputDTO(1l),
          new ScheduleMovieInputDTO(1l)
        )
      );
      scheduleService.addSchedule(
        new ScheduleInputDTO(
          LocalDate.of(2021, Month.OCTOBER, 23),
          LocalTime.of(14, 30),
          new ScheduleHallInputDTO(2l),
          new ScheduleMovieInputDTO(2l)
        )
      );
      scheduleService.addSchedule(
        new ScheduleInputDTO(
          LocalDate.of(2021, Month.OCTOBER, 23),
          LocalTime.of(17, 30),
          new ScheduleHallInputDTO(2l),
          new ScheduleMovieInputDTO(2l)
        )
      );
    }

    // NOTE: GENERATING RESERVATIONS
    if (reservationService.findAllReservations().isEmpty()) {
      reservationService.addReservation(
        new ReservationInputDTO(
          new ReservationScheduleInputDTO(1l),
          List.of(new SeatInputDTO(1l), new SeatInputDTO(2l)),
          new UserInputDTO(2l)
        )
      );
      reservationService.addReservation(
        new ReservationInputDTO(
          new ReservationScheduleInputDTO(1l),
          List.of(new SeatInputDTO(3l), new SeatInputDTO(4l)),
          new UserInputDTO(3l)
        )
      );
      reservationService.addReservation(
        new ReservationInputDTO(
          new ReservationScheduleInputDTO(1l),
          List.of(new SeatInputDTO(5l), new SeatInputDTO(6l)),
          new UserInputDTO(5l)
        )
      );
      reservationService.addReservation(
        new ReservationInputDTO(
          new ReservationScheduleInputDTO(1l),
          List.of(new SeatInputDTO(7l), new SeatInputDTO(8l)),
          new UserInputDTO(1l)
        )
      );
    }
  }
}
