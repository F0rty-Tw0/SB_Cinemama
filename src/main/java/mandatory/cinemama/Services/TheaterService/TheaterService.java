package mandatory.cinemama.Services.TheaterService;

import java.util.List;
import mandatory.cinemama.Entities.Theater;

public interface TheaterService {
  public List<Theater> findAllTheaters();

  public Theater findTheaterById(Long id);

  public Theater findTheaterByName(String name);

  public Theater findTheaterByAddress(String address);

  public void updateTheaterById(Theater theater, Long id);

  public void addTheater(Theater theater);

  public void deleteTheaterById(Long id);
}
