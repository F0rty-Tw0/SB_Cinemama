package mandatory.cinemama.Controllers.ScheduleController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.DTOs.ImputDTOs.ScheduleInputDTO;
import mandatory.cinemama.DTOs.ScheduleDTO;
import mandatory.cinemama.Entities.Schedule;
import org.springframework.format.annotation.DateTimeFormat;
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
  tags = "Schedules - (REQUIRED)",
  description = "- A secured endpoint for <b>Schedules</b>, requires a role of <b>ADMIN, MANAGER, CUSTOMER</b> to operate! - <em>(This endpoint is partly required just for the testing and learning purposes.)</em>"
)
@RequestMapping("/api/schedules")
public interface ScheduleControllerInterface {
  @ApiOperation(
    value = " - Returns all the Schedules",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Schedules</b>."
  )
  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public List<Schedule> findAllSchedules();

  @ApiOperation(
    value = " - Returns the Schedules based on the Hall Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Hall Id</b> of a Schedule to retrieve a list of <b>Schedules</b>."
  )
  @GetMapping("/hall/{hallId}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<ScheduleDTO> findSchedulesByHallId(@PathVariable Long hallId);

  @ApiOperation(
    value = " - Returns the Schedules based on the Movie Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Movie Id</b> of a Schedule to retrieve a list of <b>Schedules</b>."
  )
  @GetMapping("/movie/{movieId}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<ScheduleDTO> findSchedulesByMovieId(@PathVariable Long movieId);

  @ApiOperation(
    value = " - Returns the Schedules based on the Date and Time Slot",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Movie to retrieve a <b>Movie</b> Object.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @GetMapping("/date/{date}/time-slot/{timeSlot}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public List<ScheduleDTO> findSchedulesByDateAndTimeSlot(
    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
    @PathVariable @DateTimeFormat(
      iso = DateTimeFormat.ISO.TIME
    ) LocalTime timeSlot
  );

  @ApiOperation(
    value = " - Returns the Schedules based on the Date",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Date</b> of a Schedule to retrieve a list of <b>Schedules</b>.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @GetMapping("/date/{date}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public List<ScheduleDTO> findSchedulesByDate(
    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
  );

  @ApiOperation(
    value = " - Returns the Schedules based on the Hall Name",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Hall Name</b> of a Schedule to retrieve a list of <b>Schedules</b>.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @GetMapping("/hall/name/{name}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public List<ScheduleDTO> findSchedulesByHallName(@PathVariable String name);

  @ApiOperation(
    value = " - Returns the Schedules based on the Movie Title",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Movie Title</b> of a Schedule to retrieve a list of <b>Schedules</b>.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @GetMapping("/movie/title/{title}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public List<ScheduleDTO> findSchedulesByMovieTitle(
    @PathVariable String title
  );

  @ApiOperation(
    value = " - Returns the Schedules based on the Movie Min Age Greater than input",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Movie Min Age</b> requirement Greater than input of a Movie to retrieve a list of <b>Schedules</b>.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @GetMapping("/movie/greater-min-age/{minAge}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public List<ScheduleDTO> findSchedulesByMovieMinAgeGreaterThan(
    @PathVariable int minAge
  );

  @ApiOperation(
    value = " - Returns the Schedules based on the Movie Rating",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Movie Rating</b> of a Movie to retrieve a list of <b>Schedules</b>."
  )
  @GetMapping("/movie/rating/{rating}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public List<ScheduleDTO> findSchedulesByMovieRating(@PathVariable int rating);

  @ApiOperation(
    value = " - Returns the Schedules based on the Movie Info text",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Movie to retrieve a <b>Movie</b> Object.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @GetMapping("/movie/info/{info}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public List<ScheduleDTO> findSchedulesByMovieInfoContaining(
    @PathVariable String info
  );

  @ApiOperation(
    value = " - Returns the Schedules based on From Date and To Date",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>From Date and To Date</b> of a Schedule to retrieve a list of <b>Schedules</b>.<br><em>Requires a role of a minimum <b>MANAGER</b></em>"
  )
  @GetMapping("/end-date/{endDate}/start-date/{startDate}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
  public List<Schedule> findSchedulesByDateBetween(
    @PathVariable @DateTimeFormat(
      iso = DateTimeFormat.ISO.DATE
    ) LocalDate endDate,
    @PathVariable @DateTimeFormat(
      iso = DateTimeFormat.ISO.DATE
    ) LocalDate startDate,
    @RequestParam(required = false) String type
  );

  @ApiOperation(
    value = " - Returns the Schedules from a Theater based on From Date and To Date",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Theater id, From Date and To Date</b> of a Schedule to retrieve a list of <b>Schedules</b>.<br><em>Requires a role of a minimum <b>MANAGER</b></em>"
  )
  @GetMapping("{theaterId}/end-date/{endDate}/start-date/{startDate}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public List<Schedule> findSchedulesByHallTheaterIdAndDateBetween(
    @PathVariable Long theaterId,
    @PathVariable @DateTimeFormat(
      iso = DateTimeFormat.ISO.DATE
    ) LocalDate endDate,
    @PathVariable @DateTimeFormat(
      iso = DateTimeFormat.ISO.DATE
    ) LocalDate startDate,
    @RequestParam(required = false) String type
  );

  @ApiOperation(
    value = " - Returns the Schedules based on the Theater Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Theater Id</b> of a Schedule to retrieve a list of <b>Schedules</b>.<br><em>Requires a role of a minimum <b>CUSTOMER</b></em>"
  )
  @GetMapping("/theater/{id}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('CUSTOMER')")
  public List<ScheduleDTO> findSchedulesByHallTheaterId(Long id);

  @ApiOperation(
    value = " - Updates the Schedule based on the Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Schedule and the Schedule Object in the body in order to update an existing <b>Schedule</b>.<br><em>Requires a role of a minimum <b>MANAGER</b></em>"
  )
  @PutMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
  public void updateScheduleById(
    @RequestBody ScheduleInputDTO schedule,
    @PathVariable Long id
  );

  @ApiOperation(
    value = " - Adds a Schedule to the database",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Schedule Object</b> in the body in order to create a new <b>Schedule</b>.<br><em>Requires a role of a minimum <b>MANAGER</b></em>"
  )
  @PostMapping
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
  @ResponseStatus(HttpStatus.CREATED)
  public void addSchedule(@RequestBody ScheduleInputDTO schedule);

  @ApiOperation(
    value = " - Deletes the Schedule based on the Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of an Schedule in order to delete a the existing <b>Schedule</b>.<br><em>Requires a role of a minimum <b>MANAGER</b></em>"
  )
  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
  public void deleteScheduleById(@PathVariable Long id);
}
