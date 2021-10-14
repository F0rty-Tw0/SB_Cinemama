package mandatory.cinemama.Controllers.GenreController;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import mandatory.cinemama.Entities.Genre.Genre;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/genres")
public interface GenreControllerInterface {
  @ApiOperation("Returns all Genres available in the database")
  @GetMapping
  public List<Genre> findAllGenres();

  @ApiOperation("Returns the Genre by Id")
  @GetMapping("/{id}")
  public Genre findGenreById(Long id);

  @ApiOperation("Returns the Genre by Name")
  @GetMapping("/name/{name}")
  public Genre findGenreByName(String name);
}
