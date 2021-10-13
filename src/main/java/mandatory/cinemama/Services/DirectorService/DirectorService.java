package mandatory.cinemama.Services.DirectorService;

import java.util.List;
import mandatory.cinemama.Entities.Director;

public interface DirectorService {
  public List<Director> findAllDirectors();

  public List<Director> findDirectorByFirstName(String name);

  public List<Director> findDirectorByLastName(String name);

  public Director addDirector(Director director);
}
