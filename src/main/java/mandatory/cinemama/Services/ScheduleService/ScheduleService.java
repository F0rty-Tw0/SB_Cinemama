package mandatory.cinemama.Services.ScheduleService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.DTOs.ImputDTOs.ScheduleInputDTO;
import mandatory.cinemama.DTOs.ScheduleDTO;
import mandatory.cinemama.Entities.Schedule;

public interface ScheduleService {
  public List<Schedule> findAllSchedules();

  public List<ScheduleDTO> findSchedulesByDateAndTimeSlot(
    LocalDate date,
    LocalTime timeSlot
  );

  public List<ScheduleDTO> findSchedulesByDate(LocalDate date);

  public List<ScheduleDTO> findSchedulesByHallId(Long hallId);

  public List<ScheduleDTO> findSchedulesByMovieId(Long movieId);

  public List<ScheduleDTO> findSchedulesByHallName(String name);

  public List<ScheduleDTO> findSchedulesByMovieTitle(String title);

  public List<ScheduleDTO> findSchedulesByMovieMinAgeGreaterThan(int minAge);

  public List<ScheduleDTO> findSchedulesByMovieRating(int rating);

  public List<ScheduleDTO> findSchedulesByMovieInfoContaining(String info);

  public List<Schedule> findSchedulesByDateBetween(
    LocalDate endDate,
    LocalDate startDate,
    boolean isExtended
  );

  public List<ScheduleDTO> findSchedulesByHallTheaterId(Long id);

  public List<Schedule> findSchedulesByHallTheaterIdAndDateBetween(
    Long theaterId,
    LocalDate startDate,
    LocalDate endDate,
    boolean isExtended
  );

  public void updateScheduleById(ScheduleInputDTO schedule, Long id);

  public void addSchedule(ScheduleInputDTO schedule);

  public void deleteScheduleById(Long id);
}
