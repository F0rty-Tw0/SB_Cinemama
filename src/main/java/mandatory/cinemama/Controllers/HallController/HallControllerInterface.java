package mandatory.cinemama.Controllers.HallController;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import mandatory.cinemama.Entities.Hall;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/api/halls")
public interface HallControllerInterface {
  @ApiOperation("Returns all found Halls")
  @GetMapping
  public List<Hall> findAllHalls();

  @ApiOperation("Returns the Halls by Theater Id")
  @GetMapping("/theater/{id}")
  public List<Hall> findHallsByTheaterId(@PathVariable Long id);

  @ApiOperation("Returns the Hall based on Id")
  @GetMapping("/{id}")
  public Hall findHallById(@PathVariable Long id);

  @ApiOperation("Returns the Hall based on name")
  @GetMapping("/name/{name}")
  public Hall findHallByName(@PathVariable String name);

  @ApiOperation("Updates the hall based on the id and details we enter")
  @PatchMapping("/{id}")
  public void updateHallById(@RequestBody Hall hall, @PathVariable Long id);

  @ApiOperation(
    value = "Adds a Hall to the database",
    response = Procedure.class
  )
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void addHall(@RequestBody Hall hall);

  @ApiOperation("Deletes a Hall by Id")
  @DeleteMapping("/{id}")
  public void deleteHallById(Long id);
}
