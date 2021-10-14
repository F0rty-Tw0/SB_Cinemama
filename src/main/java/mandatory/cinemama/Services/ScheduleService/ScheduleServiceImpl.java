package mandatory.cinemama.Services.ScheduleService;

import java.util.List;

import mandatory.cinemama.Entities.Schedule.Schedule;
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
  public Schedule addSchedule(Schedule schedule) {
    Schedule newSchedule = scheduleRepository.save(schedule);
    return newSchedule;
  }
}
