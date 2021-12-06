package mandatory.cinemama.Controllers.ScheduleController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.transaction.Transactional;
import mandatory.cinemama.DTOs.ImputDTOs.ScheduleInputDTO;
import mandatory.cinemama.DTOs.ScheduleDTO;
import mandatory.cinemama.Entities.Schedule;
import mandatory.cinemama.Services.ScheduleService.ScheduleService;
import mandatory.cinemama.Utils.CheckExtended;
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
  public List<ScheduleDTO> findSchedulesByDateAndTimeSlot(
    LocalDate date,
    LocalTime timeSlot
  ) {
    return scheduleService.findSchedulesByDateAndTimeSlot(date, timeSlot);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByDate(LocalDate date) {
    return scheduleService.findSchedulesByDate(date);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByHallId(Long hallId) {
    return scheduleService.findSchedulesByHallId(hallId);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByMovieId(Long movieId) {
    return scheduleService.findSchedulesByMovieId(movieId);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByHallName(String name) {
    return scheduleService.findSchedulesByHallName(name);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByMovieTitle(String title) {
    return scheduleService.findSchedulesByMovieTitle(title);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByMovieMinAgeGreaterThan(int minAge) {
    return scheduleService.findSchedulesByMovieMinAgeGreaterThan(minAge);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByMovieRating(int rating) {
    return scheduleService.findSchedulesByMovieRating(rating);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByMovieInfoContaining(String info) {
    return scheduleService.findSchedulesByMovieInfoContaining(info);
  }

  @Override
  public List<Schedule> findSchedulesByDateBetween(
    LocalDate endDate,
    LocalDate startDate,
    String type
  ) {
    return scheduleService.findSchedulesByDateBetween(
      startDate,
      endDate,
      CheckExtended.isExtended(type)
    );
  }

  @Override
  public List<Schedule> findSchedulesByHallTheaterIdAndDateBetween(
    Long theaterId,
    LocalDate endDate,
    LocalDate startDate,
    String type
  ) {
    return scheduleService.findSchedulesByHallTheaterIdAndDateBetween(
      theaterId,
      startDate,
      endDate,
      CheckExtended.isExtended(type)
    );
  }

  @Override
  public List<ScheduleDTO> findSchedulesByHallTheaterId(Long id) {
    return scheduleService.findSchedulesByHallTheaterId(id);
  }

  @Override
  public void updateScheduleById(ScheduleInputDTO schedule, Long id) {
    scheduleService.updateScheduleById(schedule, id);
  }

  @Override
  public void addSchedule(ScheduleInputDTO schedule) {
    scheduleService.addSchedule(schedule);
  }

  @Transactional
  @Override
  public void deleteScheduleById(Long id) {
    scheduleService.deleteScheduleById(id);
  }
}
