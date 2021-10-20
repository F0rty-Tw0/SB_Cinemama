package mandatory.cinemama.Services.HallService;

import java.util.List;

import mandatory.cinemama.DTOs.HallDTO;
import mandatory.cinemama.DTOs.ImputDTOs.HallInputDTO;
import mandatory.cinemama.Entities.Hall.Hall;

public interface HallService {
  public List<Hall> findAllHalls();

  public List<HallDTO> findHallsByTheaterId(Long id);

  public Hall findHallById(Long id);

  public Hall findHallByName(String name);

  public void updateHallById(HallInputDTO hall, Long id);

  public void addHall(HallInputDTO hall); //Merry christmas

  public void deleteHallById(Long id);
}
