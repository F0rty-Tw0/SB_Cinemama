package mandatory.cinemama.Services.GenreService;

import java.util.List;
import mandatory.cinemama.Entities.Genre.EGenre;
import mandatory.cinemama.Entities.Genre.Genre;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

  private GenreRepository genreRepository;

  public GenreServiceImpl(GenreRepository genreRepository) {
    this.genreRepository = genreRepository;
  }

  private String type = "Genre";

  @Override
  public List<Genre> findAllGenres() {
    List<Genre> allGenres = genreRepository.findAll();
    return allGenres;
  }

  @Override
  public Genre findGenreById(Long id) {
    Genre genre = genreRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    return genre;
  }

  @Override
  public Genre findGenreByName(EGenre name) {
    Genre genre = genreRepository
      .findByName(name)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(name, type)
          )
      );
    return genre;
  }
}
