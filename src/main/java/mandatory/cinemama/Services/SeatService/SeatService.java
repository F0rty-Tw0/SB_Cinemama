package mandatory.cinemama.Services.SeatService;

import java.util.List;
import mandatory.cinemama.Entities.Hall.Seat;

public interface SeatService {
  public List<Seat> findAllSeats();

  public Seat findSeatById(Long id);

  public Seat findSeatByName(String name);

  public List<Seat> findSeatsByRowId(Long id);

  public List<Seat> findSeatsByRowHallId(Long id);

  public void addSeat(Seat seat);
}
