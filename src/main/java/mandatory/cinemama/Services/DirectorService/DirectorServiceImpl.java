package mandatory.cinemama.Services.DirectorService;

import java.util.List;
import mandatory.cinemama.DTOs.DirectorDTO;
import mandatory.cinemama.Entities.Director;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.DirectorRepository;
import mandatory.cinemama.Utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl implements DirectorService {

  @Autowired
  private DirectorRepository directorRepository;

  private String type = "Director";

  @Override
  public List<Director> findAllDirectors() {
    List<Director> directors = directorRepository.findAll();
    return directors;
  }

  @Override
  public Director findDirectorById(Long id) {
    Director director = directorRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    return director;
  }

  @Override
  public List<Director> findDirectorsByNameContaining(
    String firstName,
    boolean isExtended
  ) {
    List<Director> directors = directorRepository.findByNameContaining(
      firstName
    );
    ErrorMessageCreator.throwErrorIfNotFound(directors, firstName, type);
    if (!isExtended) {
      List<DirectorDTO> directorDTOs = DTOConverter.mapListDTO(
        directors,
        DirectorDTO.class
      );
      directors = DTOConverter.mapListDTO(directorDTOs, Director.class);
    }
    return directors;
  }

  @Override
  public void updateDirectorById(DirectorDTO director, Long id) {
    Director foundDirector = directorRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    foundDirector.setName(director.getName());
    directorRepository.save(foundDirector);
  }

  @Override
  public void addDirector(DirectorDTO director) {
    directorRepository.save(DTOConverter.mapDTO(director, Director.class));
  }

  @Override
  public void deleteDirectorById(Long id) {
    try {
      directorRepository.deleteById(id);
    } catch (Exception e) {
      if (e instanceof DataAccessException) {
        throw ErrorMessageCreator.throwResourceNotFoundException(id, type);
      }
    }
  }
}
