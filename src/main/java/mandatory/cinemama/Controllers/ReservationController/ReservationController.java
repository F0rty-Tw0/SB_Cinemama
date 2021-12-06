package mandatory.cinemama.Controllers.ReservationController;

import java.util.List;
import mandatory.cinemama.DTOs.ImputDTOs.ReservationInputDTO;
import mandatory.cinemama.DTOs.ReservationDTO;
import mandatory.cinemama.Entities.Reservation;
import mandatory.cinemama.Services.ReservationService.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController implements ReservationControllerInterface {

  @Autowired
  private ReservationService reservationService;

  @Override
  public List<Reservation> findAllReservations() {
    return reservationService.findAllReservations();
  }

  @Override
  public Reservation findReservationById(Long id) {
    return reservationService.findReservationById(id);
  }

  @Override
  public List<ReservationDTO> findReservationsByUserId(Long id) {
    return reservationService.findReservationsByUserId(id);
  }

  @Override
  public void updateReservationById(ReservationInputDTO reservation, Long id) {
    reservationService.updateReservationById(reservation, id);
  }

  @Override
  public void addReservation(ReservationInputDTO reservation) {
    reservationService.addReservation(reservation);
  }

  @Override
  public void deleteReservation(Long id) {
    reservationService.deleteReservationById(id);
  }
}
