package mandatory.cinemama.Services.ScheduleService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.Entities.Schedule;

public interface ScheduleService {
  public List<Schedule> findAllSchedules();

  public List<Schedule> findSchedulesByDateAndTimeSlot(
    LocalDate date,
    LocalTime timeSlot
  );

  public List<Schedule> findSchedulesByDate(LocalDate date);

  public List<Schedule> findSchedulesByHallId(Long hallId);

  public List<Schedule> findSchedulesByMovieId(Long movieId);

  public List<Schedule> findSchedulesByHallName(String name);

  public List<Schedule> findSchedulesByMovieTitle(String title);

  public List<Schedule> findSchedulesByMovieMinAgeGreaterThan(int minAge);

  public List<Schedule> findSchedulesByMovieRating(int rating);

  public List<Schedule> findSchedulesByMovieInfoContaining(String info);

  public List<Schedule> findSchedulesByDateBetween(
    LocalDate endDate,
    LocalDate startDate
  );

  public List<Schedule> findSchedulesByHallTheaterId(Long id);

  public void updateScheduleById(Schedule schedule, Long id);

  public void addSchedule(Schedule schedule);

  public void deleteScheduleById(Long id);
}
