package mandatory.cinemama.Repositories;

import mandatory.cinemama.Entities.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, Integer> {

}
