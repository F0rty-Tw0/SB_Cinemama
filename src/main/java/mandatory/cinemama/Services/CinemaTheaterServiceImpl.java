package mandatory.cinemama.Services;

import mandatory.cinemama.Entities.CinemaTheater;
import mandatory.cinemama.Repositories.CinemaTheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaTheaterServiceImpl implements CinemaTheaterService {

  private final CinemaTheaterRepository cinemaTheaterRepository;

  @Autowired
  public CinemaTheaterServiceImpl(CinemaTheaterRepository cinemaTheaterRepository) { this.cinemaTheaterRepository = cinemaTheaterRepository; }


  @Override
  public List<CinemaTheater> findAll() {
    return cinemaTheaterRepository.findAll();
  }

  @Override
  public CinemaTheater findAllById(Long id) {
    return cinemaTheaterRepository.getById(id);
  }
}
