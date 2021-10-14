package mandatory.cinemama.Controllers.HallController;

import java.util.List;
import mandatory.cinemama.Entities.Hall;
import mandatory.cinemama.Services.HallService.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class HallController implements HallControllerInterface {

  @Autowired
  private HallService hallService;

  @Override
  public List<Hall> findAllHalls() {
    return hallService.findAllHalls();
  }

  @Override
  public Hall findHallById(Long id) {
    return hallService.findHallById(id);
  }

  @Override
  public Hall findHallByName(String name) {
    return hallService.findHallByName(name);
  }

  @Override
  public void addHall(Hall hall) {
    hallService.addHall(hall);
  }

  @Override
  public void deleteHallById(Long id) {
    hallService.deleteHallById(id);
  }

  @Override
  public List<Hall> findHallsByTheaterId(Long id) {
    return hallService.findHallsByTheaterId(id);
  }

  @Transactional
  @Override
  public void deleteHallById(Long id) {
    hallService.deleteHallById(id);
  }
}
