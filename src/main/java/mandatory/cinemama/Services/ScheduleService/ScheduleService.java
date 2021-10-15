package mandatory.cinemama.Services.ScheduleService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.Entities.Schedule.Schedule;

public interface ScheduleService {
  public List<Schedule> findAllSchedules();

  public List<Schedule> findSchedulesByDateAndTimeSlot(
    LocalDate date,
    LocalTime timeSlot
  );

  public Schedule findScheduleByDateAndTimeSlotAndHallIdAndMovieId(
    LocalDate date,
    LocalTime timeSlot,
    Long hallId,
    Long movieId
  );

  public List<Schedule> findSchedulesByDate(LocalDate date);

  public List<Schedule> findSchedulesByHallId(Long hallId);

  public List<Schedule> findSchedulesByMovieId(Long movieId);

  public List<Schedule> findSchedulesByHallName(String name);

  public List<Schedule> findSchedulesByMovieTitle(String title);

  public List<Schedule> findSchedulesByMovieMinAgeGreaterThan(int minAge);

  public List<Schedule> findSchedulesByMovieRating(int rating);

  public List<Schedule> findSchedulesByMovieInfoContaining(String info);

  public void updateScheduleByDateAndTimeSlotAndHallIdAndMovieId(
    LocalDate date,
    LocalTime timeSlot,
    Long hallId,
    Long movieId,
    Schedule schedule
  );

  public void addSchedule(Schedule schedule);

  public void deleteScheduleByDateAndTimeSlotAndHallId(
    LocalDate date,
    LocalTime timeSlot,
    Long hallId
  );
}
