package mandatory.cinemama.Controllers.DirectorController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.util.List;
import mandatory.cinemama.Entities.Director;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(
  tags = "Directors (OPTIONAL)",
  description = "- A secured endpoint for <b>Directors</b>, requires a role of <b>ADMIN</b> to operate! - <em>(This endpoint was created for the testing and learning purposes only).</em>"
)
@RequestMapping("/api/directors")
public interface DirectorControllerInterface {
  @ApiOperation(
    value = " - Returns all Directors available in the database",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Directors</b>."
  )
  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public List<Director> findAllDirectors();

  @ApiOperation(
    value = " - Returns the Director by Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Director to retrieve an <b>Director</b> Object."
  )
  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public Director findDirectorById(@PathVariable Long id);

  @ApiOperation(
    value = " - Returns the Directors found by First Name",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>First Name</b> of a Director to retrieve a list of <b>Directors</b>."
  )
  @GetMapping("/first-name/{firstName}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<Director> findDirectorsByFirstName(@PathVariable String name);

  @ApiOperation(
    value = " - Returns the Directors found by Last Name",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Last Name</b> of a Director to retrieve a list of <b>Director</b>."
  )
  @GetMapping("/last-name/{lastName}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<Director> findDirectorsByLastName(@PathVariable String name);

  @ApiOperation(
    value = " - Returns the Director found by First Name and Last Name",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>First Name and Last Name</b> of a Director to retrieve a <b>Director</b> Object."
  )
  @GetMapping("/first-name/{firstName}/last-name/{lastName}")
  @PreAuthorize("hasRole('ADMIN')")
  public Director findDirectorByFirstNameAndLastName(
    @PathVariable String firstName,
    @PathVariable String lastName
  );

  @ApiOperation(
    value = " - Updates the Director based on the id and details we enter",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Director and the Director Object in the body in order to update an existing <b>Director</b>."
  )
  @PatchMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void updateDirectorById(
    @RequestBody Director director,
    @PathVariable Long id
  );

  @ApiOperation(
    value = " - Adds a Director to the database",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Director Object</b> in the body in order to create a new <b>Director</b>."
  )
  @PostMapping
  @PreAuthorize("hasRole('ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public void addDirector(@RequestBody Director director);

  @ApiOperation(
    value = " - Deletes a Director by Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Director in order to delete a the existing <b>Director</b>."
  )
  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void deleteDirectorById(@PathVariable Long id);
}
