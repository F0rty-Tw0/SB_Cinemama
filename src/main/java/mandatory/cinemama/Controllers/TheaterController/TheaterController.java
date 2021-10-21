package mandatory.cinemama.Controllers.TheaterController;

import java.util.List;
import javax.transaction.Transactional;
import mandatory.cinemama.DTOs.TheaterDTO;
import mandatory.cinemama.Entities.Theater;
import mandatory.cinemama.Services.TheaterService.TheaterService;
import mandatory.cinemama.Utils.CheckExtended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheaterController implements TheaterControllerInterface {

  @Autowired
  private TheaterService theaterService;

  @Override
  public List<Theater> findAllTheaters(String type) {
    return theaterService.findAllTheaters(CheckExtended.isExtended(type));
  }

  @Override
  public Theater findTheaterById(Long id) {
    return theaterService.findTheaterById(id);
  }

  @Override
  public List<TheaterDTO> findTheatersByName(String name) {
    return theaterService.findTheatersByName(name);
  }

  @Override
  public List<TheaterDTO> findTheatersByAddress(String address) {
    return theaterService.findTheatersByAddress(address);
  }

  @Override
  public void updateTheaterById(TheaterDTO theater, Long id) {
    theaterService.updateTheaterById(theater, id);
  }

  @Override
  public void addTheater(TheaterDTO theater) {
    theaterService.addTheater(theater);
  }

  @Transactional
  @Override
  public void deleteTheaterById(Long id) {
    theaterService.deleteTheaterById(id);
  }
}
