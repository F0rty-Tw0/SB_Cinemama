package mandatory.cinemama.Controllers.DirectorController;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import mandatory.cinemama.Entities.Director;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/api/directors")
public interface DirectorControllerInterface {
  @ApiOperation("Returns all Directors available in the database")
  @GetMapping
  public List<Director> findAllDirectors();

  @ApiOperation("Returns the Directors found by First Name")
  @GetMapping
  public List<Director> findDirectorsByFirstName(String name);

  @ApiOperation("Returns the Directors found by Last Name")
  @GetMapping
  public List<Director> findDirectorsByLastName(String name);

  @ApiOperation("Returns the Director  found by First Name and Last Name")
  @GetMapping
  public Director findDirectorByFirstNameAndLastName(
    String firstName,
    String lastName
  );

  @ApiOperation("Adds the Actor")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Director addDirector(Director director);
}
