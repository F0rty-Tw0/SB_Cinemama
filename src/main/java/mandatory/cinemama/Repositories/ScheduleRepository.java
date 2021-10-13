package mandatory.cinemama.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mandatory.cinemama.Entities.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
  
}
