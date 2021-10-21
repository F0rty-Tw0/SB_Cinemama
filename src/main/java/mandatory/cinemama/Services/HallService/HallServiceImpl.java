package mandatory.cinemama.Services.HallService;

import java.util.List;
import mandatory.cinemama.DTOs.HallDTO;
import mandatory.cinemama.DTOs.ImputDTOs.HallInputDTO;
import mandatory.cinemama.Entities.Hall.Hall;
import mandatory.cinemama.Entities.Theater;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.DataAccessException;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.HallRepository;
import mandatory.cinemama.Utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HallServiceImpl implements HallService {

  @Autowired
  private HallRepository hallRepository;

  private String type = "Hall";

  @Override
  public List<Hall> findAllHalls() {
    List<Hall> halls = hallRepository.findAll();
    return halls;
  }

  @Override
  public List<HallDTO> findHallsByTheaterId(Long id) {
    List<Hall> halls = hallRepository.findByTheaterId(id);
    ErrorMessageCreator.throwErrorIfNotFound(halls, id, type);
    return DTOConverter.mapListDTO(halls, HallDTO.class);
  }

  @Override
  public Hall findHallById(Long id) {
    Hall hall = hallRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    return hall;
  }

  @Override
  public Hall findHallByName(String name) {
    Hall hall = hallRepository
      .findByName(name)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(name, type)
          )
      );
    return hall;
  }

  @Override
  public void updateHallById(HallInputDTO hall, Long id) {
    Hall foundHall = hallRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );

    foundHall.setName(hall.getName());
    foundHall.setTheater(DTOConverter.mapDTO(hall.getTheater(), Theater.class));
    hallRepository.save(foundHall);
  }

  @Override
  public void addHall(HallInputDTO hall) {
    hallRepository.save(DTOConverter.mapDTO(hall, Hall.class));
  }

  @Override
  public void deleteHallById(Long id) {
    try {
      hallRepository.deleteById(id);
    } catch (Exception e) {
      if (
        e instanceof DataAccessException
      ) throw ErrorMessageCreator.throwResourceNotFoundException(id, type);
    }
  }
}
