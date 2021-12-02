package mandatory.cinemama.Controllers.MovieController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.DTOs.MovieDTO;
import mandatory.cinemama.DTOs.ImputDTOs.MovieInputDTO;
import mandatory.cinemama.Entities.Movie;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(
  tags = "Movies - (REQUIRED)",
  description = "- A secured endpoint for <b>Movies</b>, requires a role of <b>ADMIN, MANAGER, CUSTOMER</b> to operate! - <em>(This endpoint is partly required just for the testing and learning purposes).</em>"
)
@RequestMapping("/api/movies")
public interface MovieControllerInterface {
  @ApiOperation(
    value = " - Returns all the Movies ('type=extended' - extends the returned data - Requires ADMIN rights)",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Movies</b>.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @GetMapping
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public List<Movie> findAllMovies(@RequestParam(required = false) String type);

  @ApiOperation(
    value = " - Returns the Movie based on the Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Movie to retrieve a <b>Movie</b> Object."
  )
  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public Movie findMovieById(@PathVariable Long id);

  @ApiOperation(
    value = " - Returns the Movies Info based on the Title",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Title</b> of a Movies to retrieve a <b>Movie</b> Object.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @GetMapping("/title/{title}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public List<MovieDTO> findMovieByTitle(@PathVariable String title);

  @ApiOperation(
    value = " - Returns the Movies based on the Info text",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Info text</b> of a Movie to retrieve a list of <b>Movies</b>."
  )
  @GetMapping("/info/{info}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<MovieDTO> findMoviesByInfoContaining(@PathVariable String info);

  @ApiOperation(
    value = " - Returns the Movies based on the Minimum age which is Less than input",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Minimum Age</b> Less than your input of a Movie to retrieve a list of <b>Movies</b>."
  )
  @GetMapping("/less-min-age/{minAge}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<MovieDTO> findMoviesByMinAgeLessThan(@PathVariable int minAge);

  @ApiOperation(
    value = " - Returns the Movies based on the Minimum age which is Greater than input",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Minimum Age</b> Greater than your input of a Movie to retrieve a list of <b>Movies</b>."
  )
  @GetMapping("/greater-min-age/{minAge}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<MovieDTO> findMoviesByMinAgeGreaterThan(@PathVariable int minAge);

  @ApiOperation(
    value = " - Returns the Movies based on the Rating",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Rating</b> of a Movie to retrieve a list of <b>Movies</b>."
  )
  @GetMapping("/rating/{rating}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<MovieDTO> findMoviesByRating(@PathVariable int rating);

  @ApiOperation(
    value = " - Returns the Movies based on the Screen Time which is Less than input",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Screen Time</b> which is Less than input of a Movie to retrieve a list of <b>Movies</b>."
  )
  @GetMapping("/less-screen-time/{screenTime}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<MovieDTO> findMoviesByScreenTimeLessThan(
    @PathVariable @DateTimeFormat(pattern = "HH:mm") LocalTime screenTime
  );

  @ApiOperation(
    value = " - Returns the Movies based on the Screen Time which is Greater than input",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Screen Time</b> Greater than input of a Movie to retrieve a list of <b>Movies</b>."
  )
  @GetMapping("/greater-screen-time/{screenTime}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<MovieDTO> findMoviesByScreenTimeGreaterThan(
    @PathVariable @DateTimeFormat(pattern = "HH:mm") LocalTime screenTime
  );

  @ApiOperation(
    value = " - Updates the Movie based on the id and details we enter",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Movie and the Movie Object in the body in order to update an existing <b>Movie</b>.<br><em>Requires a role of a minimum <b>MANAGER</b></em>"
  )
  @PutMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
  public void updateMovieById(@RequestBody MovieInputDTO movie, @PathVariable Long id);

  @ApiOperation(
    value = " - Adds the Movie to the database",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Movie Object</b> in the body in order to create a new <b>Movie</b>.<br><em>Requires a role of a minimum <b>MANAGER</b></em>"
  )
  @PostMapping
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
  @ResponseStatus(HttpStatus.CREATED)
  public void addMovie(@RequestBody MovieInputDTO movie);

  @ApiOperation(
    value = " - Deletes the Movie based on the ID",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of an Movie in order to delete a the existing <b>Movie</b>.<br><em>Requires a role of a minimum <b>MANAGER</b></em>"
  )
  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
  public void deleteMovieById(@PathVariable Long id);
}
