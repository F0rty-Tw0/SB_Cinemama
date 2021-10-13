package mandatory.cinemama.Repositories;

import mandatory.cinemama.Entities.CinemaHall;
import mandatory.cinemama.Entities.CinemaTheater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaTheaterRepository extends JpaRepository<CinemaTheater, Long> {
  List<CinemaTheater> findAll();
  List<CinemaTheater> findCinemaTheaterById(Long id);
  List<CinemaTheater> findCinemaTheaterByName(String name);
  List<CinemaTheater> findCinemaTheaterByAddress(String address);
}
