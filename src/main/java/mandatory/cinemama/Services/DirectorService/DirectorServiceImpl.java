package mandatory.cinemama.Services.DirectorService;

import java.util.List;
import mandatory.cinemama.Entities.Director;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.DirectorRepository;
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
    ErrorMessageCreator.throwErrorIfNotFound(directors, "of All", type);
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
  public List<Director> findDirectorsByFirstName(String firstName) {
    List<Director> directors = directorRepository.findByFirstName(firstName);
    ErrorMessageCreator.throwErrorIfNotFound(directors, firstName, type);
    return directors;
  }

  @Override
  public List<Director> findDirectorsByLastName(String lastName) {
    List<Director> directors = directorRepository.findByLastName(lastName);
    ErrorMessageCreator.throwErrorIfNotFound(directors, lastName, type);
    return directors;
  }

  @Override
  public Director findDirectorByFirstNameAndLastName(
    String firstName,
    String lastName
  ) {
    Director director = directorRepository.findByFirstNameAndLastName(
      firstName,
      lastName
    );
    ErrorMessageCreator.throwErrorIfNotFound(
      director,
      firstName + " " + lastName,
      type
    );
    return director;
  }

  @Override
  public void updateDirectorById(Director director, Long id) {
    Director foundDirector = directorRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    foundDirector.setFirstName(director.getFirstName());
    foundDirector.setLastName(director.getLastName());
    directorRepository.save(foundDirector);
  }

  @Override
  public void addDirector(Director director) {
    directorRepository.save(director);
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
