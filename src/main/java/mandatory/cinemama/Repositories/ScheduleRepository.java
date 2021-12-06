package mandatory.cinemama.Repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.Entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
  public List<Schedule> findByDateAndTimeSlot(
    LocalDate date,
    LocalTime timeSlot
  );

  public List<Schedule> findByDate(LocalDate date);

  public List<Schedule> findByHallId(Long hallId);

  public List<Schedule> findByMovieId(Long movieId);

  public List<Schedule> findByHallName(String name);

  public List<Schedule> findByMovieTitleContaining(String title);

  public List<Schedule> findByMovieMinAgeGreaterThan(int minAge);

  public List<Schedule> findByMovieRating(int rating);

  public List<Schedule> findByMovieInfoContaining(String info);

  public List<Schedule> findByDateBetween(
    LocalDate startDate,
    LocalDate endDate
  );

  public List<Schedule> findByHallTheaterIdAndDateBetween(
    Long theaterId,
    LocalDate startDate,
    LocalDate endDate
  );

  public List<Schedule> findByHallTheaterId(Long id);
}
