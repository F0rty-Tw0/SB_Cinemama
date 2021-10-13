package mandatory.cinemama.Services;

import mandatory.cinemama.Entities.CinemaHall;

import java.util.List;

public interface CinemaHallService {
  List<CinemaHall> findAll();
  List<CinemaHall> findCinemaHallById(Long id);


}
