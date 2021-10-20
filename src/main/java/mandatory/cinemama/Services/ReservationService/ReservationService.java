package mandatory.cinemama.Services.ReservationService;

import java.util.List;
import mandatory.cinemama.Entities.Reservation;

public interface ReservationService {
  public List<Reservation> findAllReservations();

  public Reservation findReservationById(Long id);

  public List<Reservation> findReservationsByUserId(Long id);

  public void updateReservationById(Reservation reservation, Long id);

  public void addReservation(Reservation reservation);

  public void deleteReservationById(Long id);
}
