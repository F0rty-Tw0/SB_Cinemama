package mandatory.cinemama.Controllers.DirectorController;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import mandatory.cinemama.Entities.Director;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/api/directors")
public interface DirectorControllerInterface {
  @ApiOperation("Returns all Directors available in the database")
  @GetMapping
  public List<Director> findAllDirectors();

  @ApiOperation("Returns the Director by Id")
  @GetMapping("/{id}")
  public Director findDirectorById(@PathVariable Long id);

  @ApiOperation("Returns the Directors found by First Name")
  @GetMapping("/first-name/{firstName}")
  public List<Director> findDirectorsByFirstName(@PathVariable String name);

  @ApiOperation("Returns the Directors found by Last Name")
  @GetMapping("/last-name/{lastName}")
  public List<Director> findDirectorsByLastName(@PathVariable String name);

  @ApiOperation("Returns the Director found by First Name and Last Name")
  @GetMapping("/first-name/{firstName}/last-name/{lastName}")
  public Director findDirectorByFirstNameAndLastName(
    @PathVariable String firstName,
    @PathVariable String lastName
  );

  @ApiOperation("Updates the Director based on the id and details we enter")
  @PatchMapping("/{id}")
  public void updateDirectorById(@RequestBody Director director, @PathVariable Long id);

  @ApiOperation("Adds a Director to the database")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void addDirector(@RequestBody Director director);

  @ApiOperation("Deletes a Director by Id")
  @DeleteMapping("/{id}")
  public void deleteDirectorById(@PathVariable Long id);
}
