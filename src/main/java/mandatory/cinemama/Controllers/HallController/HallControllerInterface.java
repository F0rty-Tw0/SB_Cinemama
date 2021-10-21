package mandatory.cinemama.Controllers.HallController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.util.List;

import mandatory.cinemama.DTOs.HallDTO;
import mandatory.cinemama.DTOs.ImputDTOs.HallInputDTO;
import mandatory.cinemama.Entities.Hall.Hall;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(
  tags = "Halls",
  description = "- (OPTIONAL) A secured endpoint for <b>Halls</b>, requires a role of <b>ADMIN</b> to operate! - <em>(This endpoint was created for the testing and learning purposes only).</em>"
)
@RequestMapping("/api/halls")
public interface HallControllerInterface {
  @ApiOperation(
    value = " - Returns all found Halls",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Halls</b>."
  )
  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public List<Hall> findAllHalls();

  @ApiOperation(
    value = " - Returns the Halls by Theater Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Theater Id</b> of a Hall to retrieve a list of <b>Halls</b>."
  )
  @GetMapping("/theater/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<HallDTO> findHallsByTheaterId(@PathVariable Long id);

  @ApiOperation(
    value = " - Returns the Hall based on Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Hall to retrieve a  <b>Hall</b> Object."
  )
  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public Hall findHallById(@PathVariable Long id);

  @ApiOperation(
    value = " - Returns the Hall based on name",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>name</b> of a Hall to retrieve a <b>Hall</b> Object."
  )
  @GetMapping("/name/{name}")
  @PreAuthorize("hasRole('ADMIN')")
  public Hall findHallByName(@PathVariable String name);

  @ApiOperation(
    value = " - Updates the Hall based on the id and details we enter",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Hall and the Hall Object in the body in order to update an existing <b>Hall</b>."
  )
  @PutMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void updateHallById(@RequestBody HallInputDTO hall, @PathVariable Long id);

  @ApiOperation(
    value = "Adds a Hall to the database",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Hall Object</b> in the body in order to create a new <b>Hall</b>."
  )
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasRole('ADMIN')")
  public void addHall(@RequestBody HallInputDTO hall);

  @ApiOperation(
    value = " - Deletes a Hall by Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Hall in order to delete a the existing <b>Hall</b>."
  )
  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void deleteHallById(Long id);
}
