package mandatory.cinemama.Services.HallService;

import java.util.List;
import mandatory.cinemama.Entities.Hall;

public interface HallService {
  public List<Hall> findAllHalls();

  public List<Hall> findHallsByTheaterId(Long id);

  public Hall findHallById(Long id);

  public Hall findHallByName(String name);

  public void addHall(Hall hall); //Merry christmas

  public void deleteHallById(Long id);
}
