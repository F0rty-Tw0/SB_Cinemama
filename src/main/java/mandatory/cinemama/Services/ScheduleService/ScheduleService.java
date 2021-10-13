package mandatory.cinemama.Services.ScheduleService;

import java.util.List;

import mandatory.cinemama.Entities.Schedule.Schedule;

public interface ScheduleService {
  public List<Schedule> findAllSchedules();
  public Schedule addSchedule(Schedule schedule);
}
