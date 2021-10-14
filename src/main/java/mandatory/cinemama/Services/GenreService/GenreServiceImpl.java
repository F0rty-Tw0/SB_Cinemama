package mandatory.cinemama.Services.GenreService;

import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Genre.EGenre;
import mandatory.cinemama.Entities.Genre.Genre;
import mandatory.cinemama.Repositories.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

  private GenreRepository genreRepository;

  public GenreServiceImpl(GenreRepository genreRepository) {
    this.genreRepository = genreRepository;
  }

  @Override
  public List<Genre> findAllGenres() {
    List<Genre> allGenres = genreRepository.findAll();
    return allGenres;
  }

  @Override
  public Genre findGenreById(Long id) {
    Optional<Genre> genre = genreRepository.findById(id);
    return genre.get();
  }

  @Override
  public Genre findGenreByName(EGenre name) {
    Optional<Genre> genre = genreRepository.findByName(name);
    return genre.get();
  }
}
