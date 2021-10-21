package mandatory.cinemama.Services.ReservationService;

import java.util.List;

import mandatory.cinemama.DTOs.ReservationDTO;
import mandatory.cinemama.DTOs.ImputDTOs.ReservationInputDTO;
import mandatory.cinemama.Entities.Reservation;

public interface ReservationService {
  public List<Reservation> findAllReservations();

  public Reservation findReservationById(Long id);

  public List<ReservationDTO> findReservationsByUserId(Long id);

  public void updateReservationById(ReservationInputDTO reservation, Long id);

  public void addReservation(ReservationInputDTO reservation);

  public void deleteReservationById(Long id);
}
