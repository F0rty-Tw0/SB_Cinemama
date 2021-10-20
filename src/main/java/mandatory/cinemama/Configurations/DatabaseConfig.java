package mandatory.cinemama.Configurations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.Set;

import mandatory.cinemama.DTOs.ActorDTO;
import mandatory.cinemama.DTOs.DirectorDTO;
import mandatory.cinemama.DTOs.ImputDTOs.HallInputDTO;
import mandatory.cinemama.DTOs.ImputDTOs.TheaterInputDTO;
import mandatory.cinemama.DTOs.TheaterDTO;
import mandatory.cinemama.Entities.Actor;
import mandatory.cinemama.Entities.Director;
import mandatory.cinemama.Entities.Genre.EGenres;
import mandatory.cinemama.Entities.Genre.Genre;
import mandatory.cinemama.Entities.Hall.HallRow.ERows;
import mandatory.cinemama.Entities.Hall.HallRow.Row;
import mandatory.cinemama.Entities.Hall.Seat;
import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.Entities.Reservation;
import mandatory.cinemama.Entities.Schedule;
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
import mandatory.cinemama.Utils.DTOConverter;
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

    if (theaterService.findAllTheaters(false).isEmpty()) {
      theaterService.addTheater(new TheaterDTO("Odeon", "Saxogade 25"));
      theaterService.addTheater(
        new TheaterDTO("Village Cinema", "Gammel Konge Vej 99")
      );
      // theaterService.addTheater(
      //   new Theater("Coco Bongo", "Gammel Konge Vej 6")
      // );
      // theaterService.addTheater(new Theater("IMAX 3D", "Dreams str 5"));
      // theaterService.addTheater(new Theater("Theater Lux", "Lala land 42"));
    }

    if (hallService.findAllHalls().isEmpty()) {
      int numberOfTheaters = theaterService.findAllTheaters(false).size();
      for (int i = 0; i < numberOfTheaters; i++) {
        hallService.addHall(
          new HallInputDTO(
            "Sal 1",
            DTOConverter.mapDTO(
              theaterService.findAllTheaters(true).get(i),
              TheaterInputDTO.class
            )
          )
        );
        hallService.addHall(
          new HallInputDTO(
            "Sal 2",
            DTOConverter.mapDTO(
              theaterService.findAllTheaters(true).get(i),
              TheaterInputDTO.class
            )
          )
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
          seatService.addSeat(
            new Seat(
              rowService.findAllRows().get(i).getName() + j.toString(),
              rowService.findAllRows().get(i)
            )
          );
        }
      }
    }
    if (directorService.findAllDirectors().isEmpty()) {
      directorService.addDirector(new DirectorDTO("Peter Jackson"));
    }

    if (actorService.findAllActors().isEmpty()) {
      actorService.addActor(new ActorDTO("Elijah Wood"));
      actorService.addActor(new ActorDTO("Ian McKellen"));
      actorService.addActor(new ActorDTO("Liv Tyler"));
      actorService.addActor(new ActorDTO("Viggo Mortensen"));
    }

    if (genreService.findAllGenres().isEmpty()) {
      EGenres[] genres = EGenres.values();
      for (int i = 0; i < genres.length; i++) {
        genreService.addGenre(new Genre(genres[i]));
      }
    }

    if (movieService.findAllMovies(true).isEmpty()) {
      System.out.println(
        actorService.findActorsByNameContaining("Elijah Wood").get(0).getName()
      );
      movieService.addMovie(
        new Movie(
          "Lord of the Rings: The Two Towers",
          11,
          LocalTime.of(2, 59),
          "Frodo and Sam are trekking to Mordor to destroy the One Ring of Power while Gimli, Legolas and Aragorn search for the orc-captured Merry and Pippin. All along, nefarious wizard Saruman awaits the Fellowship members at the Orthanc Tower in Isengard.",
          8.7d,
          Set.of(
            DTOConverter.mapDTO(
              actorService.findAllActors().get(0),
              Actor.class
            ),
            DTOConverter.mapDTO(
              actorService.findAllActors().get(1),
              Actor.class
            ),
            DTOConverter.mapDTO(
              actorService.findAllActors().get(2),
              Actor.class
            ),
            DTOConverter.mapDTO(
              actorService.findAllActors().get(3),
              Actor.class
            )
          ),
          Set.of(
            DTOConverter.mapDTO(
              directorService.findAllDirectors().get(0),
              Director.class
            )
          ),
          Set.of(
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
          DTOConverter.mapDTO(
            movieService.findAllMovies(true).get(0),
            Movie.class
          ),
          hallService.findAllHalls().get(0)
        )
      );
      scheduleService.addSchedule(
        new Schedule(
          LocalTime.of(14, 30),
          LocalDate.of(2021, Month.JANUARY, 25),
          DTOConverter.mapDTO(
            movieService.findAllMovies(true).get(0),
            Movie.class
          ),
          hallService.findAllHalls().get(0)
        )
      );
      scheduleService.addSchedule(
        new Schedule(
          LocalTime.of(14, 31),
          LocalDate.of(2021, Month.JANUARY, 24),
          DTOConverter.mapDTO(
            movieService.findAllMovies(true).get(0),
            Movie.class
          ),
          hallService.findAllHalls().get(0)
        )
      );
      scheduleService.addSchedule(
        new Schedule(
          LocalTime.of(14, 30),
          LocalDate.of(2021, Month.JANUARY, 24),
          DTOConverter.mapDTO(
            movieService.findAllMovies(true).get(0),
            Movie.class
          ),
          hallService.findAllHalls().get(3)
        )
      );
    }

    if (reservationService.findAllReservations().isEmpty()) {
      reservationService.addReservation(
        new Reservation(
          false,
          scheduleService.findAllSchedules().get(0),
          List.of(
            seatService.findAllSeats().get(0),
            seatService.findAllSeats().get(1)
          ),
          userService.findAllUsers().get(0)
        )
      );
    }
  }
}
