package mandatory.cinemama.Services.DirectorService;

import java.util.List;
import mandatory.cinemama.Entities.Director;
import mandatory.cinemama.Repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl implements DirectorService {

  private DirectorRepository directorRepository;
  //change
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
  public List<Director> findDirectorsByFirstName(String name) {
    List<Director> directors = directorRepository.findDirectorsByFirstName(name);
    return directors;
  }

  @Override
  public List<Director> findDirectorsByLastName(String name) {
    List<Director> directors = directorRepository.findDirectorsByLastName(name);
    return directors;
  }

  @Override
  public Director addDirector(Director director) {
    Director newDirector = directorRepository.save(director);
    return newDirector;
  }

  @Override
  public void deleteDirectorById(Long id) {
    directorRepository.deleteDirectorById(id);
  }
}
