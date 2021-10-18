package mandatory.cinemama.Controllers.ActorController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import mandatory.cinemama.Entities.Actor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(tags = "Actor")
@RequestMapping("/api/actors")
public interface ActorControllerInterface {
  @ApiOperation("Returns the Actor by the Id")
  @GetMapping("/{id}")
  public Actor findActorById(@PathVariable Long id);

  @ApiOperation("Returns all of the Actors")
  @GetMapping
  public List<Actor> findAllActors();

  @ApiOperation("Returns the Actors by the First Name")
  @GetMapping("/first-name/{firstName}")
  public List<Actor> findActorsByFirstName(@PathVariable String firstName);

  @ApiOperation("Returns the Actors by the Last Name")
  @GetMapping("/last-name/{lastName}")
  public List<Actor> findActorsByLastName(@PathVariable String lastName);

  @ApiOperation("Returns the Actor by the First Name and Last Name")
  @GetMapping("/first-name/{firstName}/last-name/{lastName}")
  public Actor findActorsByFirstNameAndLastName(
    @PathVariable String firstName,
    @PathVariable String lastName
  );

  @ApiOperation("Updates an Actor by Id and the details we enter")
  @PatchMapping("/{id}")
  public void updateActorById(@RequestBody Actor actor, @PathVariable Long id);

  @ApiOperation("Adds an Actor to the database")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void addActor(@RequestBody Actor actor);

  @ApiOperation("Deletes the Actor by Id")
  @DeleteMapping("/{id}")
  public void deleteActorById(@PathVariable Long id);
}
