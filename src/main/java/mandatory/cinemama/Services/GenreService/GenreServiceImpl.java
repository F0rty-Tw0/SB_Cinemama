package mandatory.cinemama.Services.GenreService;

import java.util.List;
import mandatory.cinemama.Entities.Genre.EGenres;
import mandatory.cinemama.Entities.Genre.Genre;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

  @Autowired
  private GenreRepository genreRepository;

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
  public Genre findGenreByName(String name) {
    try {
      Genre genre = genreRepository
        .findByName(EGenres.valueOf(name.toUpperCase()))
        .get();
      return genre;
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(
        ErrorMessageCreator.NotFoundErrorMessage(name, type)
      );
    }
  }

  @Override
  public void addGenre(Genre genre) {
    genreRepository.save(genre);
  }
}
