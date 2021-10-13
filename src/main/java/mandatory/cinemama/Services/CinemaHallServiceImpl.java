package mandatory.cinemama.Services;

import mandatory.cinemama.Entities.CinemaHall;
import mandatory.cinemama.Repositories.CinemaHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {

  private final CinemaHallRepository cinemaHallRepository;

  @Autowired
  public CinemaHallServiceImpl (CinemaHallRepository cinemaHallRepository) { this.cinemaHallRepository = cinemaHallRepository; }

  @Override
  public List<CinemaHall> findAll() {
    List<CinemaHall> cinemaHalls = cinemaHallRepository.findAll();
    return cinemaHalls;
  }

  @Override
  public List<CinemaHall> findById(Long id) {
    List<CinemaHall> cinemaHalls = cinemaHallRepository.findById(id);
    return cinemaHalls;
  }
}
