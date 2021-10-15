package mandatory.cinemama.Controllers.TheaterController;

import io.swagger.annotations.ApiOperation;
import java.util.List;

import mandatory.cinemama.Entities.Hall;
import mandatory.cinemama.Entities.Theater;
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

@RequestMapping("/api/theaters")
public interface TheaterControllerInterface {
  @ApiOperation("Returns all found Theaters")
  @GetMapping
  public List<Theater> findAllTheaters();

  @ApiOperation("Returns the Theater based on Id")
  @GetMapping("/{id}")
  public Theater findTheaterById(@PathVariable Long id);

  @ApiOperation("Returns the Theater based on name")
  @GetMapping("/name/{name}")
  public Theater findTheaterName(@PathVariable String name);

  @ApiOperation("Returns the Theater based on address")
  @GetMapping("/address/{address}")
  public Theater findTheaterAddress(@PathVariable String address);

  @ApiOperation("Updates the Theater based on the id and details we enter")
  @PatchMapping("/{id}")
  public void updateTheaterById(@RequestBody Theater theater, @PathVariable Long id);

  @ApiOperation(
    value = "Adds a Theater to the database",
    response = Procedure.class
  )
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void addTheater(@RequestBody Theater theater);

  @ApiOperation("Deletes a Theater by Id")
  @DeleteMapping("/{id}")
  public void deleteTheaterById(@PathVariable Long id);
}
