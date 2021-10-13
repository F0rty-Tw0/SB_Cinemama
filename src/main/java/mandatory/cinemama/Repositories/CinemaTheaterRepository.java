package mandatory.cinemama.Repositories;

import mandatory.cinemama.Entities.CinemaTheater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinemaTheaterRepository extends JpaRepository<CinemaTheater, Integer> {

}
