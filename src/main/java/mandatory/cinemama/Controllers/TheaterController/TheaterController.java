package mandatory.cinemama.Controllers.TheaterController;

import java.util.List;
import javax.transaction.Transactional;
import mandatory.cinemama.Entities.Theater;
import mandatory.cinemama.Services.TheaterService.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
  public Theater findTheaterByName(String name) {
    return theaterService.findTheaterByName(name);
  }

  @Override
  public Theater findTheaterByAddress(String address) {
    return theaterService.findTheaterByAddress(address);
  }

  @Override
  public void updateTheaterById(Theater theater, Long id) {
    theaterService.updateTheaterById(theater, id);
  }

  @Override
  public void addTheater(Theater theater) {
    theaterService.addTheater(theater);
  }

  @Transactional
  @Override
  public void deleteTheaterById(Long id) {
    theaterService.deleteTheaterById(id);
  }
}
