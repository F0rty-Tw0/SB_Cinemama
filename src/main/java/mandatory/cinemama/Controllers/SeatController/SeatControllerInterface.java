package mandatory.cinemama.Controllers.SeatController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.util.List;
import mandatory.cinemama.Entities.Hall.Seat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(
  tags = "Seats",
  description = "- (OPTIONAL)A secured endpoint for <b>Seats</b>, requires a role of <b>ADMIN</b> to operate! - <em>(This endpoint was created for the testing and learning purposes only).</em>"
)
@RequestMapping("/api/seats")
public interface SeatControllerInterface {
  @ApiOperation(
    value = " - Returns all Seats available in the database",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Seats</b>."
  )
  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public List<Seat> findAllSeats();

  @ApiOperation(
    value = " - Returns the Seat by Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Seat to retrieve an <b>Seat</b> Object."
  )
  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public Seat findSeatById(Long id);

  @ApiOperation(
    value = " - Returns the Seat by Name",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Name</b> of a Seat to retrieve an <b>Seat</b> Object."
  )
  @GetMapping("/name/{name}")
  @PreAuthorize("hasRole('ADMIN')")
  public Seat findSeatByName(String name);

  @ApiOperation(
    value = " - Returns the Seats by Row Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Row Id</b> of a Seat to retrieve a list <b>Seats</b>."
  )
  @GetMapping("/row/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<Seat> findSeatsByRowId(Long id);

  @ApiOperation(
    value = " - Returns All the Seats inside a Hall by Hall Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Hall Id</b> of a Hall to retrieve a list of <b>Seats</b>."
  )
  @GetMapping("/hall/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<Seat> findSeatsByRowHallId(Long id);
}
