package mandatory.cinemama.Repositories;

import mandatory.cinemama.Entities.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaHallRepository extends JpaRepository<CinemaHall, Long> {
  public List<CinemaHall> findAll();
  public List<CinemaHall> findCinemaHallsById(Long id);
}
