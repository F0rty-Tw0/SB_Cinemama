package mandatory.cinemama.Controllers.HallController;

import java.util.List;
import javax.transaction.Transactional;

import mandatory.cinemama.DTOs.HallDTO;
import mandatory.cinemama.DTOs.ImputDTOs.HallInputDTO;
import mandatory.cinemama.Entities.Hall.Hall;
import mandatory.cinemama.Services.HallService.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
  public void updateHallById(HallInputDTO hall, Long id) {
    hallService.updateHallById(hall, id);
  }

  @Override
  public void addHall(HallInputDTO hall) {
    hallService.addHall(hall);
  }

  @Override
  public List<HallDTO> findHallsByTheaterId(Long id) {
    return hallService.findHallsByTheaterId(id);
  }

  @Transactional
  @Override
  public void deleteHallById(Long id) {
    hallService.deleteHallById(id);
  }
}
