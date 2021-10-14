package mandatory.cinemama.Controllers.TheaterController;

import java.util.List;
import mandatory.cinemama.Entities.Theater;
import mandatory.cinemama.Services.TheaterService.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class TheaterController implements TheaterControllerInterface {

  @Autowired
  private TheaterService theaterService;

  @Override
  public List<Theater> findAllTheaters() {
    return theaterService.findAllTheaters();
  }

  @Override
  public Theater findTheaterById(Long id) {
    return theaterService.findTheaterById(id);
  }

  @Override
  public Theater findTheaterName(String name) {
    return theaterService.findTheaterByName(name);
  }

  @Override
  public Theater findTheaterAddress(String address) {
    return theaterService.findTheaterByAddress(address);
  }

  @Override
  public Theater addTheater(Theater theater) {
    return theaterService.addTheater(theater);
  }

  @Transactional
  @Override
  public void deleteMovieById(Long id) {
    theaterService.deleteTheaterById(id);
  }
}
