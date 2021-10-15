package mandatory.cinemama.Services.DirectorService;

import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Director;
import mandatory.cinemama.Repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl implements DirectorService {

  private DirectorRepository directorRepository;

  @Autowired
  public DirectorServiceImpl(DirectorRepository directorRepository) {
    this.directorRepository = directorRepository;
  }

  @Override
  public List<Director> findAllDirectors() {
    List<Director> directors = directorRepository.findAll();
    return directors;
  }

  @Override
  public Director findDirectorById(Long id) {
    Optional<Director> director = directorRepository.findById(id);
    return director.get();
  }

  @Override
  public List<Director> findDirectorsByFirstName(String firstName) {
    List<Director> directors = directorRepository.findByFirstName(firstName);
    return directors;
  }

  @Override
  public List<Director> findDirectorsByLastName(String lastName) {
    List<Director> directors = directorRepository.findByLastName(lastName);
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
    return director;
  }

  @Override
  public void updateDirectorById(Director director, Long id) {
    Director foundDirector = directorRepository.getById(id);
    if (foundDirector != null) {
      foundDirector.setFirstName(director.getFirstName());
      foundDirector.setLastName(director.getLastName());
      directorRepository.save(foundDirector);
    } else {
      System.out.println("This one should be handled by error handler");
    }
  }

  @Override
  public void addDirector(Director director) {
    directorRepository.save(director);
  }

  @Override
  public void deleteDirectorById(Long id) {
    directorRepository.deleteById(id);
  }
}
