package mandatory.cinemama.Controllers.TheaterController;

import mandatory.cinemama.Entities.Theater;
import mandatory.cinemama.Services.TheaterService.TheaterService;
import mandatory.cinemama.Services.TheaterService.TheaterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController implements TheaterControllerInterface {

  @Autowired
  private TheaterService theaterService;

  @Override
  public List<Theater> findAllTheater(@RequestParam(required = false) String type) {
    return theaterService.findAllTheaters();
  }

  @Override
  public Theater findTheaterById(@RequestParam(required = false) String type,
      @PathVariable Long id) {
    return theaterService.findTheaterById(id);
  }

  @Override
  public Theater findTheaterName(@RequestParam(required = false) String type,
      @PathVariable String name) {
    return theaterService.findTheaterByName(name);
  }

  @Override
  public Theater findTheaterAddress(@RequestParam(required = false) String type,
      @PathVariable String address) {
    return theaterService.findTheaterByAddress(address);
  }

  @Override
  public Theater addTheater(@RequestBody Theater theater) {
    return theaterService.addTheater(theater);
  }
}
