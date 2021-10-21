package mandatory.cinemama.Services.TheaterService;

import java.util.List;

import mandatory.cinemama.DTOs.TheaterDTO;
import mandatory.cinemama.Entities.Theater;

public interface TheaterService {
  public List<Theater> findAllTheaters(boolean isExtended);

  public Theater findTheaterById(Long id);

  public List<TheaterDTO> findTheatersByName(String name);

  public List<TheaterDTO> findTheatersByAddress(String address);

  public void updateTheaterById(TheaterDTO theater, Long id);

  public void addTheater(TheaterDTO theater);

  public void deleteTheaterById(Long id);
}
