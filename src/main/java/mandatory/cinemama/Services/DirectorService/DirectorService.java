package mandatory.cinemama.Services.DirectorService;

import java.util.List;
import mandatory.cinemama.Entities.Director;

public interface DirectorService {
  public List<Director> findAllDirectors();

  public List<Director> findDirectorsByFirstName(String firstName);

  public List<Director> findDirectorsByLastName(String lastName);

  public Director findDirectorByFirstNameAndLastName(
    String firstName,
    String lastName
  );

  public Director addDirector(Director director);
}
