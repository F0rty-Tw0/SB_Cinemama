package mandatory.cinemama.Services.HallService;

import java.util.List;
import mandatory.cinemama.Entities.Hall;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.DataAccessException;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HallServiceImpl implements HallService {

  private HallRepository hallRepository;

  @Autowired
  public HallServiceImpl(HallRepository hallRepository) {
    this.hallRepository = hallRepository;
  }

  private String type = "Hall";

  @Override
  public List<Hall> findAllHalls() {
    List<Hall> halls = hallRepository.findAll();
    ErrorMessageCreator.throwErrorIfNotFound(halls, "of All", type);
    return halls;
  }

  @Override
  public List<Hall> findHallsByTheaterId(Long id) {
    List<Hall> halls = hallRepository.findByTheaterId(id);
    ErrorMessageCreator.throwErrorIfNotFound(halls, id, type);
    return halls;
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
  public void updateHallById(Hall hall, Long id) {
    Hall foundHall = hallRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );

    foundHall.setName(hall.getName());
    foundHall.setTheater(hall.getTheater());
    hallRepository.save(foundHall);
  }

  @Override
  public void addHall(Hall hall) {
    hallRepository.save(hall);
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
