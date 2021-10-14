package mandatory.cinemama.Services.DirectorService;

import java.util.List;
import mandatory.cinemama.Entities.Director;

public interface DirectorService {
  public List<Director> findAllDirectors();

  public Director findDirectorById(Long id);

  public List<Director> findDirectorsByFirstName(String firstName);

  public List<Director> findDirectorsByLastName(String lastName);

  public Director findDirectorByFirstNameAndLastName(
    String firstName,
    String lastName
  );

  public void addDirector(Director director);

  public void deleteDirectorById(Long id);
}
