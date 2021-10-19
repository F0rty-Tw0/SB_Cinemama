package mandatory.cinemama.Controllers.GenreController;

import java.util.List;
import mandatory.cinemama.Entities.Genre.Genre;
import mandatory.cinemama.Services.GenreService.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController implements GenreControllerInterface {

  @Autowired
  private GenreService genreService;

  @Override
  public List<Genre> findAllGenres() {
    return genreService.findAllGenres();
  }

  @Override
  public Genre findGenreById(Long id) {
    return genreService.findGenreById(id);
  }

  @Override
  public Genre findGenreByName(String name) {
    return genreService.findGenreByName(name);
  }
}
