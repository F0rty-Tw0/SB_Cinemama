package mandatory.cinemama.Services.TheaterService;

import java.util.List;
import mandatory.cinemama.Entities.Theater;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TheaterServiceImpl implements TheaterService {

  private final TheaterRepository theaterRepository;

  @Autowired
  public TheaterServiceImpl(TheaterRepository theaterRepository) {
    this.theaterRepository = theaterRepository;
  }

  private String type = "Theater";

  @Override
  public List<Theater> findAllTheaters() {
    List<Theater> theaters = theaterRepository.findAll();
    ErrorMessageCreator.throwErrorIfNotFound(theaters, "of All", type);
    return theaters;
  }

  @Override
  public Theater findTheaterById(Long id) {
    Theater theater = theaterRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    return theater;
  }

  @Override
  public Theater findTheaterByName(String name) {
    Theater theater = theaterRepository
      .findByName(name)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(name, type)
          )
      );
    return theater;
  }

  @Override
  public Theater findTheaterByAddress(String address) {
    Theater theater = theaterRepository
      .findByAddress(address)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(address, type)
          )
      );
    return theater;
  }

  @Override
  public void updateTheaterById(Theater theater, Long id) {
    Theater foundTheater = theaterRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    foundTheater.setName(theater.getName());
    foundTheater.setAddress(theater.getAddress());
    theaterRepository.save(foundTheater);
  }

  @Override
  public void addTheater(Theater theater) {
    theaterRepository.save(theater);
  }

  @Override
  public void deleteTheaterById(Long id) {
    try {
      theaterRepository.deleteById(id);
    } catch (Exception e) {
      if (e instanceof DataAccessException) {
        throw ErrorMessageCreator.throwResourceNotFoundException(id, type);
      }
    }
  }


}
