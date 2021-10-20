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
  public List<Director> findDirectorsByNameContaining(String name) {
    return directorService.findDirectorsByNameContaining(name);
  }

  @Override
  public void updateDirectorById(Director director, Long id) {
    directorService.updateDirectorById(director, id);
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
