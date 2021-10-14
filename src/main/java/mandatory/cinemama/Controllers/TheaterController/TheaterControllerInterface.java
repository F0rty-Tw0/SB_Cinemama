package mandatory.cinemama.Controllers.TheaterController;

import io.swagger.annotations.ApiOperation;
import mandatory.cinemama.Entities.Theater;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping("/api/theaters")
public interface TheaterControllerInterface {

  @ApiOperation("Returns all found theaters")
  @GetMapping()
  public List<Theater> findAllTheater(@RequestParam(required = false) String type);

  @ApiOperation("Returns the theater based on Id")
  @GetMapping("/id/{id}")
  public Theater findTheaterById(@RequestParam(required = false) String type,
      @PathVariable Long id);

  @ApiOperation("Returns the theater based on name")
  @GetMapping("/name/{name}")
  public Theater findTheaterName(@RequestParam(required = false) String type,
      @PathVariable String name);

  @ApiOperation("Returns the theater based on address")
  @GetMapping("/address/{address")
  public Theater findTheaterAddress(@RequestParam(required = false) String type,
      @PathVariable String address);

  @ApiOperation(value = "Adds a theater to the database", response = Procedure.class)
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Theater addTheater(@RequestBody Theater theater);
}
