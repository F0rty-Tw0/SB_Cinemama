package mandatory.cinemama.Services.TheaterService;

import java.util.List;
import mandatory.cinemama.DTOs.TheaterDTO;
import mandatory.cinemama.Entities.Theater;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.TheaterRepository;
import mandatory.cinemama.Utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TheaterServiceImpl implements TheaterService {

  @Autowired
  private TheaterRepository theaterRepository;

  private String type = "Theater";

  @Override
  public List<Theater> findAllTheaters(boolean isExtended) {
    List<Theater> theaters = theaterRepository.findAll();
    if (!isExtended) {
      List<TheaterDTO> theaterDTOs = DTOConverter.mapListDTO(
        theaters,
        TheaterDTO.class
      );
      theaters = DTOConverter.mapListDTO(theaterDTOs, Theater.class);
    }
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
  public List<TheaterDTO> findTheatersByName(String name) {
    List<Theater> theaters = theaterRepository.findByNameContaining(name);
    ErrorMessageCreator.throwErrorIfNotFound(theaters, name, type);
    return DTOConverter.mapListDTO(theaters, TheaterDTO.class);
  }

  @Override
  public List<TheaterDTO> findTheatersByAddress(String address) {
    List<Theater> theaters = theaterRepository.findByAddressContaining(address);
    ErrorMessageCreator.throwErrorIfNotFound(theaters, address, type);
    return DTOConverter.mapListDTO(theaters, TheaterDTO.class);
  }

  @Override
  public void updateTheaterById(TheaterDTO theater, Long id) {
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
  public void addTheater(TheaterDTO theater) {
    theaterRepository.save(DTOConverter.mapDTO(theater, Theater.class));
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
