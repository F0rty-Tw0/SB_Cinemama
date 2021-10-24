package mandatory.cinemama.Controllers.DirectorController;

import java.util.List;
import mandatory.cinemama.DTOs.DirectorDTO;
import mandatory.cinemama.Entities.Director;
import mandatory.cinemama.Services.DirectorService.DirectorService;
import mandatory.cinemama.Utils.CheckExtended;
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
  public List<Director> findDirectorsByNameContaining(
    String name,
    String type
  ) {
    return directorService.findDirectorsByNameContaining(
      name,
      CheckExtended.isExtended(type)
    );
  }

  @Override
  public void updateDirectorById(DirectorDTO director, Long id) {
    directorService.updateDirectorById(director, id);
  }

  @Override
  public void addDirector(DirectorDTO director) {
    directorService.addDirector(director);
  }

  @Override
  public void deleteDirectorById(Long id) {
    directorService.deleteDirectorById(id);
  }
}
