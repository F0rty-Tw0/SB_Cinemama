package mandatory.cinemama.Controllers.MovieController;

import io.swagger.annotations.ApiOperation;
import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.Entities.Movie;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/api/movies")
public interface MovieControllerInterface {
  @ApiOperation("Returns all the Movies")
  @GetMapping
  public List<Movie> findAllMovies();

  @ApiOperation("Returns the Movie based on the Id")
  @GetMapping("/{id}")
  public Movie findMovieById(@PathVariable Long id);

  @ApiOperation("Returns the Movies based on the Title")
  @GetMapping("/title/{title}")
  public Movie findMovieByTitle(@PathVariable String title);

  @ApiOperation("Returns the Movies based on the Info text")
  @GetMapping("/info/{info}")
  public List<Movie> findMoviesByInfoContaining(@PathVariable String info);

  @ApiOperation(
    "Returns the Movies based on the Minimum age which is Less than input"
  )
  @GetMapping("/less-min-age/{minAge}")
  public List<Movie> findMoviesByMinAgeLessThan(@PathVariable int minAge);

  @ApiOperation(
    "Returns the Movies based on the Minimum age which is Greater than input"
  )
  @GetMapping("/greater-min-age/{minAge}")
  public List<Movie> findMoviesByMinAgeGreaterThan(@PathVariable int minAge);

  @ApiOperation("Returns the Movies based on the Rating")
  @GetMapping("/rating/{rating}")
  public List<Movie> findMoviesByRating(@PathVariable int rating);

  @ApiOperation(
    "Returns the Movies based on the Screen Time which is Less than input"
  )
  @GetMapping("/less-screen-time/{screenTime}")
  public List<Movie> findMoviesByScreenTimeLessThan(
    @PathVariable @DateTimeFormat(pattern = "HH:mm") LocalTime screenTime
  );

  @ApiOperation(
    "Returns the Movies based on the Screen Time which is Greater than input"
  )
  @GetMapping("/greater-screen-time/{screenTime}")
  public List<Movie> findMoviesByScreenTimeGreaterThan(
    @PathVariable @DateTimeFormat(pattern = "HH:mm") LocalTime screenTime
  );

  @ApiOperation("Returns the Info based on the Title")
  @GetMapping("/info-from-title{title}")
  public String findInfoByTitle(@PathVariable String title);

  @ApiOperation("Updates the Movie based on the id and details we enter")
  @PatchMapping("/{id}")
  public void updateMovieById(@RequestBody Movie movie, @PathVariable Long id);

  @ApiOperation("Adds the Movie to the database")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void addMovie(@RequestBody Movie movie);

  @ApiOperation("Deletes the Movie based on the ID")
  @DeleteMapping("/{id}")
  public void deleteMovieById(@PathVariable Long id);
}
