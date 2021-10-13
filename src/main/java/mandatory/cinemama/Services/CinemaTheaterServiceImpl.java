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
    List<CinemaTheater> cinemaTheaters = cinemaTheaterRepository.findAll();
    return cinemaTheaters;
  }

  @Override
  public List<CinemaTheater> findAllById(Long id) {
    List<CinemaTheater> cinemaTheaters = cinemaTheaterRepository.findAllById(id);
    return cinemaTheaterRepository.getById(id);
  }

  @Override
  public List<CinemaTheater> findAllByName(String name) {
    List<CinemaTheater> cinemaTheaters = cinemaTheaterRepository.findAllByName(name);
    return cinemaTheaters;
  }

  @Override
  public CinemaTheater findByAddress(String address) {
    return null;
  }
}
