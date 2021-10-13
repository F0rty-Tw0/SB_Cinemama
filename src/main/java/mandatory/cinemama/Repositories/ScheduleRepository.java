package mandatory.cinemama.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mandatory.cinemama.Entities.Schedule.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
  public List<Schedule> findAll();
}
