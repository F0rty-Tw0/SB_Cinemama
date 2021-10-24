package mandatory.cinemama.Controllers.DirectorController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.util.List;
import mandatory.cinemama.DTOs.DirectorDTO;
import mandatory.cinemama.Entities.Director;
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
  tags = "Directors",
  description = "- (OPTIONAL) A secured endpoint for <b>Directors</b>, requires a role of <b>ADMIN, MANAGER, CUSTOMER</b> to operate! - <em>(This endpoint was created for the testing and learning purposes only).</em>"
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
    value = " - Returns the Directors found by Name ('type=extended' - extends the returned data - Requires ADMIN rights)",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Name</b> of a Director to retrieve a list of <b>Directors</b>.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @GetMapping("/name/{name}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public List<Director> findDirectorsByNameContaining(
    @PathVariable String name,
    @RequestParam(required = false) String type
  );

  @ApiOperation(
    value = " - Updates the Director based on the id and details we enter",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Director and the Director Object in the body in order to update an existing <b>Director</b>."
  )
  @PutMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void updateDirectorById(
    @RequestBody DirectorDTO director,
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
  public void addDirector(@RequestBody DirectorDTO director);

  @ApiOperation(
    value = " - Deletes a Director by Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Director in order to delete a the existing <b>Director</b>."
  )
  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void deleteDirectorById(@PathVariable Long id);
}
