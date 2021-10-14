package mandatory.cinemama.Controllers.HallController;


import mandatory.cinemama.Entities.Hall;
import mandatory.cinemama.Services.HallService.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/halls")
public class HallController implements HallControllerInterface {

  @Autowired
  private HallService hallService;

  @Override
  public List<Hall> findAllHalls(@RequestParam(required = false) String type) {
    return hallService.findAllHalls();
  }

  @Override
  public Hall findHallById(@RequestParam(required = false) String type,
      @PathVariable Long id) {
    return hallService.findHallById(id);
  }

  @Override
  public Hall findHallByName(@RequestParam(required = false) String type,
      @PathVariable String name) {
    return hallService.findHallByName(name);
  }

  @Override
  public Hall addHall(@RequestBody Hall hall) {
    return hallService.addHall(hall);
  }
}
