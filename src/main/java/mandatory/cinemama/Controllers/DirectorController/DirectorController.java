package mandatory.cinemama.Controllers.DirectorController;

import java.util.List;
import mandatory.cinemama.Entities.Director;
import mandatory.cinemama.Services.DirectorService.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectorController implements DirectorControllerInterface {

  @Autowired
  private DirectorService directorService;

  @Override
  public List<Director> findAllDirectors() {
    return directorService.findAllDirectors();
  }

  @Override
  public Director findDirectorById(Long id) {
    return directorService.findDirectorById(id);
  }

  @Override
  public List<Director> findDirectorsByFirstName(String firstName) {
    return directorService.findDirectorsByFirstName(firstName);
  }

  @Override
  public List<Director> findDirectorsByLastName(String lastName) {
    return directorService.findDirectorsByLastName(lastName);
  }

  @Override
  public Director findDirectorByFirstNameAndLastName(
    String firstName,
    String lastName
  ) {
    return directorService.findDirectorByFirstNameAndLastName(
      firstName,
      lastName
    );
  }

  @Override
  public void addDirector(Director director) {
    directorService.addDirector(director);
  }

  @Override
  public void deleteDirectorById(Long id) {
    directorService.deleteDirectorById(id);
  }
}
