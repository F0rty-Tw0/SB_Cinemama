package mandatory.cinemama.Controllers.TheaterController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.util.List;
import mandatory.cinemama.DTOs.TheaterDTO;
import mandatory.cinemama.Entities.Theater;
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
  tags = "Theaters",
  description = "- (OPTIONAL) A secured endpoint for <b>Theaters</b>, requires a role of <b>ADMIN, MANAGER, CUSTOMER</b> to operate! - <em>(This endpoint was created for the testing and learning purposes only).</em>"
)
@RequestMapping("/api/theaters")
public interface TheaterControllerInterface {
  @ApiOperation(
    value = " - Returns all found Theaters ('type=extended' - extends the returned data - Requires ADMIN rights)",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Theaters</b>."
  )
  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public List<Theater> findAllTheaters(
    @RequestParam(required = false) String type
  );

  @ApiOperation(
    value = " - Returns the Theater based on Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Theater to retrieve a <b>Theater</b> Object."
  )
  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public Theater findTheaterById(@PathVariable Long id);

  @ApiOperation(
    value = " - Returns the Theaters based on name",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>name</b> of a Theater to retrieve  a list of <b>Theaters</b> Object.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @GetMapping("/name/{name}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public List<TheaterDTO> findTheatersByName(@PathVariable String name);

  @ApiOperation(
    value = " - Returns the Theaters based on address",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>address</b> of a Theater to retrieve a list of <b>Theaters</b> Object.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @GetMapping("/address/{address}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public List<TheaterDTO> findTheatersByAddress(@PathVariable String address);

  @ApiOperation(
    value = " - Updates the Theater based on the id and details we enter",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Theater and the Theater Object in the body in order to update an existing <b>Theater</b>."
  )
  @PutMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void updateTheaterById(
    @RequestBody TheaterDTO theater,
    @PathVariable Long id
  );

  @ApiOperation(
    value = " - Adds a Theater to the database",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Theater Object</b> in the body in order to create a new <b>Theater</b>."
  )
  @PostMapping
  @PreAuthorize("hasRole('ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public void addTheater(@RequestBody TheaterDTO theater);

  @ApiOperation(
    value = " - Deletes a Theater by Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Theater in order to delete a the existing <b>Theater</b>."
  )
  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void deleteTheaterById(@PathVariable Long id);
}
