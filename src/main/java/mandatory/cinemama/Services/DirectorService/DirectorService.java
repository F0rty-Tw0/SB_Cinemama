package mandatory.cinemama.Services.DirectorService;

import java.util.List;
import mandatory.cinemama.Entities.Director;

public interface DirectorService {
  public List<Director> findAllDirectors();

  public List<Director> findDirectorsByFirstName(String name);

  public List<Director> findDirectorsByLastName(String name);

  public Director addDirector(Director director);

  public void deleteDirectorById(Long id);
}
