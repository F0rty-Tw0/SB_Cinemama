package Services;

import Repositories.ActorRepository;
import Repositories.GenreRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import mandatory.cinemama.Entities.Genre.Genre;

@Service
public class GenreService{
      GenreRepository genreRepository;

      public GenreService(GenreRepository genreRepository){this.genreRepository = genreRepository;}

}
