package mandatory.cinemama.Services.TheaterService;

import java.util.List;
import mandatory.cinemama.Entities.Theater;

public interface TheaterService {
  List<Theater> findAllTheaters();
  Theater findTheaterById(Long id);
  Theater findTheaterByName(String name);
  Theater findTheaterByAddress(String address);
  Theater addTheater(Theater theater);
}
