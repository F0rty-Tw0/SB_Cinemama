package mandatory.cinemama.Controllers.GenreController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.util.List;
import mandatory.cinemama.Entities.Genre.Genre;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(
  tags = "Genres",
  description = "- (OPTIONAL) A secured endpoint for <b>Genres</b>, requires a role of <b>ADMIN</b> to operate! - <em>(This endpoint was created for the testing and learning purposes only).</em>"
)
@RequestMapping("/api/genres")
public interface GenreControllerInterface {
  @ApiOperation(
    value = " - Returns all Genres available in the database",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Genres</b>."
  )
  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public List<Genre> findAllGenres();

  @ApiOperation(
    value = " - Returns the Genre by Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Genre to retrieve a <b>Genre</b> Object."
  )
  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public Genre findGenreById(Long id);

  @ApiOperation(
    value = " - Returns the Genre by Name",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Name</b> of a Genre to retrieve a <b>Genre</b> Object."
  )
  @GetMapping("/name/{name}")
  @PreAuthorize("hasRole('ADMIN')")
  public Genre findGenreByName(String name);
}
