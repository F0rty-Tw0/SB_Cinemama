package mandatory.cinemama.Services.DirectorService;

import java.util.List;

import mandatory.cinemama.DTOs.DirectorDTO;
import mandatory.cinemama.Entities.Director;

public interface DirectorService {
  public List<Director> findAllDirectors();

  public Director findDirectorById(Long id);

  public List<Director> findDirectorsByNameContaining(String name, boolean isExtended);

  public void updateDirectorById(DirectorDTO director, Long id);

  public void addDirector(DirectorDTO director);

  public void deleteDirectorById(Long id);
}
