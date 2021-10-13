package mandatory.cinemama.Repositories;

import mandatory.cinemama.Entities.CinemaTheater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaTheaterRepository extends JpaRepository<CinemaTheater, Long> {

}
