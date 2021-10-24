package mandatory.cinemama.Controllers.ActorController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.util.List;

import mandatory.cinemama.DTOs.ActorDTO;
import mandatory.cinemama.Entities.Actor;
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
  tags = "Actor",
  description = "- (OPTIONAL) A secured endpoint for <b>Actors</b>, requires a role of <b>ADMIN</b> to operate! - <em>(This endpoint was created for the testing and learning purposes only)</em>"
)
@RequestMapping("/api/actors")
public interface ActorControllerInterface {
  @ApiOperation(
    value = " - Returns all of the Actors",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Actors</b>."
  )
  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public List<Actor> findAllActors();

  @ApiOperation(
    value = " - Returns the Actor by the Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of an Actor to retrieve an <b>Actor</b> Object."
  )
  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public Actor findActorById(@PathVariable Long id);

  @ApiOperation(
    value = " - Returns the Actors by the Name ('type=extended' - extends the returned data - Requires ADMIN rights)",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Name</b> of an Actor to retrieve a list of <b>Actors</b>."
  )
  @GetMapping("/name/{name}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<Actor> findActorsByNameContaining(@PathVariable String name,  @RequestParam(required = false) String type);

  @ApiOperation(
    value = " - Updates an Actor by Id and the details we enter",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of an Actor and the Actor Object in the body in order to update an existing <b>Actor</b>."
  )
  @PutMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void updateActorById(@RequestBody ActorDTO actor, @PathVariable Long id);

  @ApiOperation(
    value = " - Adds an Actor to the database",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Actor Object</b> in the body in order to create a new <b>Actor</b>."
  )
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasRole('ADMIN')")
  public void addActor(@RequestBody ActorDTO actor);

  @ApiOperation(
    value = " - Deletes the Actor by Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of an Actor in order to delete a the existing <b>Actor</b>."
  )
  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void deleteActorById(@PathVariable Long id);
}
