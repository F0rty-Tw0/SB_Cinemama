package mandatory.cinemama.Controllers.ScheduleController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.Entities.Schedule.Schedule;
import mandatory.cinemama.Services.ScheduleService.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController implements ScheduleControllerInterface {

  @Autowired
  private ScheduleService scheduleService;

  @Override
  public List<Schedule> findAllSchedules() {
    return scheduleService.findAllSchedules();
  }

  @Override
  public List<Schedule> findSchedulesByDateAndTimeSlot(
    LocalDate date,
    LocalTime timeSlot
  ) {
    return scheduleService.findSchedulesByDateAndTimeSlot(date, timeSlot);
  }

  @Override
  public Schedule findScheduleByDateAndTimeSlotAndHallIdAndMovieId(
    LocalDate date,
    LocalTime timeSlot,
    Long hallId,
    Long movieId
  ) {
    return scheduleService.findScheduleByDateAndTimeSlotAndHallIdAndMovieId(
      date,
      timeSlot,
      hallId,
      movieId
    );
  }

  @Override
  public List<Schedule> findSchedulesByDate(LocalDate date) {
    return scheduleService.findSchedulesByDate(date);
  }

  @Override
  public List<Schedule> findSchedulesByHallId(Long hallId) {
    return scheduleService.findSchedulesByHallId(hallId);
  }

  @Override
  public List<Schedule> findSchedulesByMovieId(Long movieId) {
    return scheduleService.findSchedulesByMovieId(movieId);
  }

  @Override
  public List<Schedule> findSchedulesByHallName(String name) {
    return scheduleService.findSchedulesByHallName(name);
  }

  @Override
  public List<Schedule> findSchedulesByMovieTitle(String title) {
    return scheduleService.findSchedulesByMovieTitle(title);
  }

  @Override
  public List<Schedule> findSchedulesByMovieMinAgeGreaterThan(int minAge) {
    return scheduleService.findSchedulesByMovieMinAgeGreaterThan(minAge);
  }

  @Override
  public List<Schedule> findSchedulesByMovieRating(int rating) {
    return scheduleService.findSchedulesByMovieRating(rating);
  }

  @Override
  public List<Schedule> findSchedulesByMovieInfoContaining(String info) {
    return scheduleService.findSchedulesByMovieInfoContaining(info);
  }

  @Override
  public void updateScheduleByDateAndTimeSlotAndHallIdAndMovieId(
    LocalDate date,
    LocalTime timeSlot,
    Long hallId,
    Long movieId,
    Schedule schedule
  ) {
    scheduleService.updateScheduleByDateAndTimeSlotAndHallIdAndMovieId(
      date,
      timeSlot,
      hallId,
      movieId,
      schedule
    );
  }

  @Override
  public void addSchedule(Schedule schedule) {
    scheduleService.addSchedule(schedule);
  }

  @Override
  public void deleteScheduleByDateAndTimeSlotAndHallId(
    LocalDate date,
    LocalTime timeSlot,
    Long hallId
  ) {
    scheduleService.deleteScheduleByDateAndTimeSlotAndHallId(
      date,
      timeSlot,
      hallId
    );
  }
}
