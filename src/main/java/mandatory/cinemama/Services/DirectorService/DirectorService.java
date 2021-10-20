package mandatory.cinemama.Services.DirectorService;

import java.util.List;
import mandatory.cinemama.Entities.Director;

public interface DirectorService {
  public List<Director> findAllDirectors();

  public Director findDirectorById(Long id);

  public List<Director> findDirectorsByNameContaining(String name);

  public void updateDirectorById(Director director, Long id);

  public void addDirector(Director director);

  public void deleteDirectorById(Long id);
}
