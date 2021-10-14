package mandatory.cinemama.Services.TheaterService;

import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Theater;
import mandatory.cinemama.Repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterServiceImpl implements TheaterService {

  private final TheaterRepository theaterRepository;

  @Autowired
  public TheaterServiceImpl(TheaterRepository theaterRepository) {
    this.theaterRepository = theaterRepository;
  }

  @Override
  public List<Theater> findAllTheaters() {
    List<Theater> theaters = theaterRepository.findAll();
    return theaters;
  }

  @Override
  public Theater findTheaterById(Long id) {
    Optional<Theater> theater = theaterRepository.findById(id);
    return theater.get();
  }

  @Override
  public Theater findTheaterByName(String name) {
    Optional<Theater> theater = theaterRepository.findByName(name);
    return theater.get();
  }

  @Override
  public Theater findTheaterByAddress(String address) {
    Optional<Theater> theater = theaterRepository.findByAddress(address);
    return theater.get();
  }

  @Override
  public Theater addTheater(Theater theater) {
    Theater newTheater = theaterRepository.save(theater);
    return newTheater;
  }
}
