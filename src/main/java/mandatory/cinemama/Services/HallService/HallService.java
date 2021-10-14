package mandatory.cinemama.Services.HallService;

import java.util.List;
import mandatory.cinemama.Entities.Hall;

public interface HallService {
  List<Hall> findAllHalls();
  Hall findHallById(Long id);
  Hall findHallByName(String name);
  Hall addHall(Hall hall);
  void deleteHallById(Long id);
}
