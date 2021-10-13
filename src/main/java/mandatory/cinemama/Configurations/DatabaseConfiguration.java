package mandatory.cinemama.Configurations;

import mandatory.cinemama.Entities.Director;
import mandatory.cinemama.Repositories.DirectorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
public class DatabaseConfiguration implements CommandLineRunner {

  private DirectorRepository directorRepository;

  public DatabaseConfiguration(DirectorRepository directorRepository) {
    // TODO: Add repositories
    this.directorRepository = directorRepository;

  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("config runs");
    directorRepository.save(new Director("John", "Smith"));
    // TODO: Setup data to database
  }
}
