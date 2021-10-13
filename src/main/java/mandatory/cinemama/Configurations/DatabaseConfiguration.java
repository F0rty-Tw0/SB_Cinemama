package mandatory.cinemama.Configurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component 
@Profile("main")
public class DatabaseConfiguration implements CommandLineRunner{

  public DatabaseConfiguration() {
    // TODO: Add repositories
  }

  @Override
  public void run(String... args) throws Exception {
   // TODO: Setup data to database
  }
  
}
