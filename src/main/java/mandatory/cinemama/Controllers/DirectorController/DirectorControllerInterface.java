package mandatory.cinemama.Controllers.DirectorController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import mandatory.cinemama.Entities.Director;

@RequestMapping("/api/directors")
public interface DirectorControllerInterface {

  @ApiOperation("Returns all Directors available in the database")
  @GetMapping
  public List<Director> findAllDirectors();
}
