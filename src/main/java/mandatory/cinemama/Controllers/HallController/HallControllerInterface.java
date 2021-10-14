package mandatory.cinemama.Controllers.HallController;

import io.swagger.annotations.ApiOperation;
import mandatory.cinemama.Entities.Hall;
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

@RequestMapping("/api/halls")
public interface HallControllerInterface {

  @ApiOperation("Returns all found Halls")
  @GetMapping
  public List<Hall> findAllHalls(@RequestParam(required = false) String type);

  @ApiOperation("Returns the Hall based on Id")
  @GetMapping("/id/{id}")
  public Hall findHallById(@RequestParam(required = false) String type,
      @PathVariable Long id);

  @ApiOperation("Returns the Hall based on name")
  @GetMapping("/name/{name}")
  public Hall findHallByName(@RequestParam(required = false) String type,
      @PathVariable String name);

  @ApiOperation(value = "Adds a Hall to the database", response = Procedure.class)
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Hall addHall(@RequestBody Hall hall);
}
