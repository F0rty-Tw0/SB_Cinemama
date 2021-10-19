package mandatory.cinemama.Controllers.SeatController;

import java.util.List;
import mandatory.cinemama.Entities.Hall.Seat;
import mandatory.cinemama.Services.SeatService.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController implements SeatControllerInterface {

  @Autowired
  private SeatService seatService;

  @Override
  public List<Seat> findAllSeats() {
    return seatService.findAllSeats();
  }

  @Override
  public Seat findSeatById(Long id) {
    return seatService.findSeatById(id);
  }

  @Override
  public Seat findSeatByName(String name) {
    return seatService.findSeatByName(name);
  }

  @Override
  public List<Seat> findSeatsByRowId(Long id) {
    return seatService.findSeatsByRowId(id);
  }
}
