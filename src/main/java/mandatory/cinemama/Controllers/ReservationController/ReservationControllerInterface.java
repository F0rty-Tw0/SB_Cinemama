package mandatory.cinemama.Controllers.ReservationController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.util.List;
import mandatory.cinemama.DTOs.ReservationDTO;
import mandatory.cinemama.DTOs.ImputDTOs.ReservationInputDTO;
import mandatory.cinemama.Entities.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(
  tags = "Reservations - (REQUIRED)",
  description = "- A secured endpoint for <b>Reservations</b>, requires a role of <b>ADMIN, MANAGER, CUSTOMER</b> to operate!"
)
@RequestMapping("/api/reservations")
public interface ReservationControllerInterface {
  @ApiOperation(
    value = " - Returns all the Reservations",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Reservations</b>."
  )
  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public List<Reservation> findAllReservations();

  @ApiOperation(
    value = " - Returns the Reservation based on the Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Reservation to retrieve a <b>Reservation</b> Object."
  )
  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public Reservation findReservationById(Long id);

  @ApiOperation(
    value = " - Returns the Reservations based on the User Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>User Id</b> of a User to retrieve a <b>Reservation</b> Object."
  )
  @GetMapping("/user/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<ReservationDTO> findReservationsByUserId(Long id);

  @ApiOperation(
    value = " - Updates the Reservation based on the id and details we enter",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Reservation and the Reservation Object in the body in order to update an existing <b>Reservation</b>.<br><em>Requires a role of a minimum <b>MANAGER</b></em>"
  )
  @PutMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
  public void updateReservationById(@RequestBody ReservationInputDTO reservation, Long id);

  @ApiOperation(
    value = " - Adds the Reservation to the database",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Reservation Object</b> in the body in order to create a new <b>Reservation</b>.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @PostMapping
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  @ResponseStatus(HttpStatus.CREATED)
  public void addReservation(@RequestBody ReservationInputDTO reservation);

  @ApiOperation(
    value = " - Deletes the Reservation based on the ID",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of an Reservation in order to delete a the existing <b>Reservation</b>.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public void deleteReservation(Long id);
}
