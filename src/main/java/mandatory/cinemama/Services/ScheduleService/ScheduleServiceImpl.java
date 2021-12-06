package mandatory.cinemama.Services.ScheduleService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.DTOs.ImputDTOs.ScheduleInputDTO;
import mandatory.cinemama.DTOs.ScheduleDTO;
import mandatory.cinemama.Entities.Hall.Hall;
import mandatory.cinemama.Entities.Movie;
import mandatory.cinemama.Entities.Schedule;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.DataAccessException;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.MovieRepository;
import mandatory.cinemama.Repositories.ScheduleRepository;
import mandatory.cinemama.Utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

  @Autowired
  private ScheduleRepository scheduleRepository;

  @Autowired
  private MovieRepository movieRepository;

  private String type = "Schedule";

  @Override
  public List<Schedule> findAllSchedules() {
    List<Schedule> schedules = scheduleRepository.findAll();
    return schedules;
  }

  @Override
  public List<ScheduleDTO> findSchedulesByDateAndTimeSlot(
    LocalDate date,
    LocalTime timeSlot
  ) {
    List<Schedule> schedules = scheduleRepository.findByDateAndTimeSlot(
      date,
      timeSlot
    );
    ErrorMessageCreator.throwErrorIfNotFound(
      schedules,
      "Date : " + date + " and Time Slot: " + timeSlot,
      type
    );
    return DTOConverter.mapListDTO(schedules, ScheduleDTO.class);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByDate(LocalDate date) {
    List<Schedule> schedules = scheduleRepository.findByDate(date);
    ErrorMessageCreator.throwErrorIfNotFound(schedules, date, type);
    return DTOConverter.mapListDTO(schedules, ScheduleDTO.class);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByHallId(Long hallId) {
    List<Schedule> schedules = scheduleRepository.findByHallId(hallId);
    ErrorMessageCreator.throwErrorIfNotFound(schedules, hallId, type);
    return DTOConverter.mapListDTO(schedules, ScheduleDTO.class);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByMovieId(Long movieId) {
    List<Schedule> schedules = scheduleRepository.findByMovieId(movieId);
    ErrorMessageCreator.throwErrorIfNotFound(schedules, movieId, type);
    return DTOConverter.mapListDTO(schedules, ScheduleDTO.class);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByHallName(String name) {
    List<Schedule> schedules = scheduleRepository.findByHallName(name);
    ErrorMessageCreator.throwErrorIfNotFound(schedules, name, type);
    return DTOConverter.mapListDTO(schedules, ScheduleDTO.class);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByMovieTitle(String title) {
    List<Schedule> schedules = scheduleRepository.findByMovieTitleContaining(
      title
    );
    ErrorMessageCreator.throwErrorIfNotFound(schedules, title, type);
    return DTOConverter.mapListDTO(schedules, ScheduleDTO.class);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByMovieMinAgeGreaterThan(int minAge) {
    List<Schedule> schedules = scheduleRepository.findByMovieMinAgeGreaterThan(
      minAge
    );
    ErrorMessageCreator.throwErrorIfNotFound(schedules, minAge, type);
    return DTOConverter.mapListDTO(schedules, ScheduleDTO.class);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByMovieRating(int rating) {
    List<Schedule> schedules = scheduleRepository.findByMovieRating(rating);
    ErrorMessageCreator.throwErrorIfNotFound(schedules, rating, type);
    return DTOConverter.mapListDTO(schedules, ScheduleDTO.class);
  }

  @Override
  public List<ScheduleDTO> findSchedulesByMovieInfoContaining(String info) {
    List<Schedule> schedules = scheduleRepository.findByMovieInfoContaining(
      info
    );
    ErrorMessageCreator.throwErrorIfNotFound(schedules, info, type);
    return DTOConverter.mapListDTO(schedules, ScheduleDTO.class);
  }

  @Override
  public List<Schedule> findSchedulesByDateBetween(
    LocalDate endDate,
    LocalDate startDate,
    boolean isExtended
  ) {
    List<Schedule> schedules = scheduleRepository.findByDateBetween(
      endDate,
      startDate
    );
    if (!isExtended) {
      List<ScheduleDTO> schedulesDTO = DTOConverter.mapListDTO(
        schedules,
        ScheduleDTO.class
      );
      schedules = DTOConverter.mapListDTO(schedulesDTO, Schedule.class);
    }
    ErrorMessageCreator.throwErrorIfNotFound(
      schedules,
      "From: " + startDate + " To: " + endDate,
      type
    );
    return schedules;
  }

  @Override
  public List<ScheduleDTO> findSchedulesByHallTheaterId(Long id) {
    List<Schedule> schedules = scheduleRepository.findByHallTheaterId(id);
    ErrorMessageCreator.throwErrorIfNotFound(schedules, id, type);
    return DTOConverter.mapListDTO(schedules, ScheduleDTO.class);
  }

  @Override
  public List<Schedule> findSchedulesByHallTheaterIdAndDateBetween(
    Long theaterId,
    LocalDate endDate,
    LocalDate startDate,
    boolean isExtended
  ) {
    List<Schedule> schedules = scheduleRepository.findByHallTheaterIdAndDateBetween(
      theaterId,
      endDate,
      startDate
    );
    if (!isExtended) {
      List<ScheduleDTO> schedulesDTO = DTOConverter.mapListDTO(
        schedules,
        ScheduleDTO.class
      );
      schedules = DTOConverter.mapListDTO(schedulesDTO, Schedule.class);
    }
    ErrorMessageCreator.throwErrorIfNotFound(
      schedules,
      "From: " + startDate + " To: " + endDate,
      type
    );
    return schedules;
  }

  @Override
  public void updateScheduleById(ScheduleInputDTO schedule, Long id) {
    Schedule newSchedule = scheduleRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );

    if (schedule.getMovie() != null) {
      newSchedule.setMovie(
        DTOConverter.mapDTO(schedule.getMovie(), Movie.class)
      );

      schedule.setScreenTime(
        movieRepository
          .findById(schedule.getMovie().getId())
          .get()
          .getScreenTime()
      );
      newSchedule.setScreenTime(schedule.getScreenTime());
    }

    if (schedule.getHall() != null) {
      newSchedule.setHall(DTOConverter.mapDTO(schedule.getHall(), Hall.class));
    }

    if (schedule.getDate() != null) {
      newSchedule.setDate(schedule.getDate());
    }

    if (schedule.getTimeSlot() != null) {
      newSchedule.setTimeSlot(schedule.getTimeSlot());
    }

    scheduleRepository.save(newSchedule);
  }

  @Override
  public void addSchedule(ScheduleInputDTO schedule) {
    if (schedule.getScreenTime() == null) {
      schedule.setScreenTime(
        movieRepository
          .findById(schedule.getMovie().getId())
          .get()
          .getScreenTime()
      );
    }
    scheduleRepository.save(DTOConverter.mapDTO(schedule, Schedule.class));
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
