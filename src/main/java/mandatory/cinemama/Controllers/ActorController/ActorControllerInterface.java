package mandatory.cinemama.Controllers.ActorController;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import mandatory.cinemama.Entities.Actor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface ActorControllerInterface {
  @ApiOperation("Returns the Actor by the ID")
  @GetMapping("/{id}")
  public Actor findActorById(@PathVariable Long id);

  @ApiOperation("Returns all of the Actors")
  @GetMapping
  public List<Actor> findAllActors();

  @ApiOperation("Returns the Actors by the First Name ")
  @GetMapping("/first-name/{firstName}")
  public List<Actor> findActorsByFirstName(@PathVariable String firstName);

  @ApiOperation("Returns the Actors by the Last Name")
  @GetMapping("/last-name/{lastName}")
  public List<Actor> findActorsByLastName(@PathVariable String lastName);

  @ApiOperation("Adds the Actor")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Actor addActor(@RequestBody Actor actor);

  @ApiOperation("Deletes an Actor from the database")
  @DeleteMapping("{id}")
  public void deleteActorById(@PathVariable Long id);

}
