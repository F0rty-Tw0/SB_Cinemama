package mandatory.cinemama.Controllers.SeatController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import mandatory.cinemama.Entities.Hall.Seat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "Seats ")
@RequestMapping("/api/seats")
public interface SeatControllerInterface {
  @ApiOperation("Returns all Seats available in the database")
  @GetMapping
  public List<Seat> findAllSeats();

  @ApiOperation("Returns the Seat by Id")
  @GetMapping("/{id}")
  public Seat findSeatById(Long id);

  @ApiOperation("Returns the Seat by Name")
  @GetMapping("/name/{name}")
  public Seat findSeatByName(String name);

  @ApiOperation("Returns the Seats by Row Id")
  @GetMapping("/row/{id}")
  public List<Seat> findSeatsByRowId(Long id);
}
