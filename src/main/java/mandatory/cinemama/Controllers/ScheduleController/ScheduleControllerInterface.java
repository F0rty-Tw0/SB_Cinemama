package mandatory.cinemama.Controllers.ScheduleController;

import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.Entities.Schedule.Schedule;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/api/schedules")
public interface ScheduleControllerInterface {
  @ApiOperation("Returns all the Schedules")
  @GetMapping
  public List<Schedule> findAllSchedules();

  @ApiOperation("Returns the Schedules based on the Date and Time Slot")
  @GetMapping("/date/{date}/time-slot/{timeSlot}")
  public List<Schedule> findSchedulesByDateAndTimeSlot(
    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
    @PathVariable @DateTimeFormat(
      iso = DateTimeFormat.ISO.TIME
    ) LocalTime timeSlot
  );

  @ApiOperation(
    "Returns the Schedules based on the Date,Time Slot, Hall Id and Movie Id"
  )
  @GetMapping("/date/{date}/time-slot/{timeSlot}/hall/{hallId}/movie/{movieId}")
  public Schedule findScheduleByDateAndTimeSlotAndHallIdAndMovieId(
    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
    @PathVariable @DateTimeFormat(
      iso = DateTimeFormat.ISO.TIME
    ) LocalTime timeSlot,
    @PathVariable Long hallId,
    @PathVariable Long movieId
  );

  @ApiOperation("Returns the Schedules based on the Date")
  @GetMapping("/date/{date}")
  public List<Schedule> findSchedulesByDate(
    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
  );

  @ApiOperation("Returns the Schedules based on the Hall Id")
  @GetMapping("/hall/{hallId}")
  public List<Schedule> findSchedulesByHallId(@PathVariable Long hallId);

  @ApiOperation("Returns the Schedules based on the Movie Id")
  @GetMapping("/movie/{movieId}")
  public List<Schedule> findSchedulesByMovieId(@PathVariable Long movieId);

  @ApiOperation("Returns the Schedules based on the Hall Name")
  @GetMapping("/hall/name/{name}")
  public List<Schedule> findSchedulesByHallName(@PathVariable String name);

  @ApiOperation("Returns the Schedules based on the Movie Title")
  @GetMapping("/movie/title/{title}")
  public List<Schedule> findSchedulesByMovieTitle(@PathVariable String title);

  @ApiOperation(
    "Returns the Schedules based on the Movie Min Age Greater than input"
  )
  @GetMapping("/movie/greater-min-age/{minAge}")
  public List<Schedule> findSchedulesByMovieMinAgeGreaterThan(
    @PathVariable int minAge
  );

  @ApiOperation("Returns the Schedules based on the Movie Rating")
  @GetMapping("/movie/rating/{rating}")
  public List<Schedule> findSchedulesByMovieRating(@PathVariable int rating);

  @ApiOperation("Returns the Schedules based on the Movie Info text")
  @GetMapping("/movie/info/{info}")
  public List<Schedule> findSchedulesByMovieInfoContaining(
    @PathVariable String info
  );

  @ApiOperation(
    "Updates the Schedule based on the Date,Time Slot, Hall Id and Movie Id"
  )
  @PatchMapping(
    "/date/{date}/time-slot/{timeSlot}/hall/{hallId}/movie/{movieId}"
  )
  public void updateScheduleByDateAndTimeSlotAndHallIdAndMovieId(
    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
    @PathVariable @DateTimeFormat(
      iso = DateTimeFormat.ISO.TIME
    ) LocalTime timeSlot,
    @PathVariable Long hallId,
    @PathVariable Long movieId,
    @RequestBody Schedule schedule
  );

  @ApiOperation("Adds a Schedule to the database")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void addSchedule(@RequestBody Schedule schedule);

  @ApiOperation("Deletes the Movie based on the Date, Time Slot, and Hall Id")
  @DeleteMapping("/{id}")
  public void deleteScheduleByDateAndTimeSlotAndHallId(
    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
    @PathVariable @DateTimeFormat(
      iso = DateTimeFormat.ISO.TIME
    ) LocalTime timeSlot,
    @PathVariable Long hallId
  );
}
