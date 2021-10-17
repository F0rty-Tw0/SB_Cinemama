package mandatory.cinemama.Services.ScheduleService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.Entities.Schedule;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.DataAccessException;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

  private ScheduleRepository scheduleRepository;

  @Autowired
  public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
    this.scheduleRepository = scheduleRepository;
  }

  private String type = "Schedule";

  @Override
  public List<Schedule> findAllSchedules() {
    List<Schedule> schedules = scheduleRepository.findAll();
    ErrorMessageCreator.throwErrorIfNotFound(schedules, "of All", type);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByDateAndTimeSlot(
    LocalDate date,
    LocalTime timeSlot
  ) {
    List<Schedule> schedules = scheduleRepository.findByDateAndTimeSlot(
      date,
      timeSlot
    );
    ErrorMessageCreator.throwErrorIfNotFound(schedules, "Date and Time Slot", type);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByDate(LocalDate date) {
    List<Schedule> schedules = scheduleRepository.findByDate(date);
    ErrorMessageCreator.throwErrorIfNotFound(schedules, "Date", type);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByHallId(Long hallId) {
    List<Schedule> schedules = scheduleRepository.findByHallId(hallId);
    ErrorMessageCreator.throwErrorIfNotFound(schedules, "Hall Id", type);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByMovieId(Long movieId) {
    List<Schedule> schedules = scheduleRepository.findByMovieId(movieId);
    ErrorMessageCreator.throwErrorIfNotFound(schedules, "Movie Id", type);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByHallName(String name) {
    List<Schedule> schedules = scheduleRepository.findByHallName(name);
    ErrorMessageCreator.throwErrorIfNotFound(schedules, "Name", type);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByMovieTitle(String title) {
    List<Schedule> schedules = scheduleRepository.findByMovieTitle(title);
    ErrorMessageCreator.throwErrorIfNotFound(schedules, "Movie Title", type);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByMovieMinAgeGreaterThan(int minAge) {
    List<Schedule> schedules = scheduleRepository.findByMovieMinAgeGreaterThan(minAge);
    ErrorMessageCreator.throwErrorIfNotFound(schedules, "Movies with Minimum Age Greater Than", type);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByMovieRating(int rating) {
    List<Schedule> schedules = scheduleRepository.findByMovieRating(rating);
    ErrorMessageCreator.throwErrorIfNotFound(schedules, "Movie Rating", type);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByMovieInfoContaining(String info) {
    List<Schedule> schedules = scheduleRepository.findByMovieInfoContaining(info);
    ErrorMessageCreator.throwErrorIfNotFound(schedules, "Movie Info Containing", type);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByDateBetween(
    LocalDate endDate,
    LocalDate startDate
  ) {
    List<Schedule> schedules = scheduleRepository.findByDateBetween(
      endDate,
      startDate
    );
    ErrorMessageCreator.throwErrorIfNotFound(schedules, "Dates Between", type);
    return schedules;
  }

  @Override
  public void updateScheduleById(Long id, Schedule schedule) {
    Schedule newSchedule = scheduleRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    newSchedule.setDate(schedule.getDate());
    newSchedule.setScreenTime(schedule.getMovie().getScreenTime());
    if (schedule.getTimeSlot() != null) {
      newSchedule.setTimeSlot(schedule.getTimeSlot());
    }
    scheduleRepository.save(newSchedule);
  }

  @Override
  public void addSchedule(Schedule schedule) {
    schedule.setScreenTime(schedule.getMovie().getScreenTime());
    scheduleRepository.save(schedule);
  }

  @Override
  public void deleteScheduleById(Long id) {
    try {
      scheduleRepository.deleteById(id);
    } catch (Exception e) {
      if (e instanceof DataAccessException) {
        throw ErrorMessageCreator.throwResourceNotFoundException(id, type);
      }
    }
  }
}
