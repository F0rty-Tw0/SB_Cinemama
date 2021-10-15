package mandatory.cinemama.Services.ScheduleService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.Entities.Schedule;
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

  @Override
  public List<Schedule> findAllSchedules() {
    List<Schedule> schedules = scheduleRepository.findAll();
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
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByDate(LocalDate date) {
    List<Schedule> schedules = scheduleRepository.findByDate(date);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByHallId(Long hallId) {
    List<Schedule> schedules = scheduleRepository.findByHallId(hallId);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByMovieId(Long movieId) {
    List<Schedule> schedules = scheduleRepository.findByMovieId(movieId);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByHallName(String name) {
    List<Schedule> schedules = scheduleRepository.findByHallName(name);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByMovieTitle(String title) {
    List<Schedule> schedules = scheduleRepository.findByMovieTitle(title);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByMovieMinAgeGreaterThan(int minAge) {
    List<Schedule> schedules = scheduleRepository.findByMovieMinAgeGreaterThan(
      minAge
    );
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByMovieRating(int rating) {
    List<Schedule> schedules = scheduleRepository.findByMovieRating(rating);
    return schedules;
  }

  @Override
  public List<Schedule> findSchedulesByMovieInfoContaining(String info) {
    List<Schedule> schedules = scheduleRepository.findByMovieInfoContaining(
      info
    );
    return schedules;
  }

  @Override
  public void updateScheduleById(Long id, Schedule schedule) {
    Schedule newSchedule = scheduleRepository.getById(id);
    if (newSchedule != null) {
      newSchedule.setDate(schedule.getDate());
      newSchedule.setScreenTime(schedule.getMovie().getScreenTime());
      if (schedule.getTimeSlot() != null) {
        newSchedule.setTimeSlot(schedule.getTimeSlot());
      }
      scheduleRepository.save(newSchedule);
    } else {
      System.out.println("This one should be handled by error handler");
    }
  }

  @Override
  public void addSchedule(Schedule schedule) {
    schedule.setScreenTime(schedule.getMovie().getScreenTime());
    scheduleRepository.save(schedule);
  }

  @Override
  public void deleteScheduleById(Long id) {
    scheduleRepository.deleteById(id);
  }
}
