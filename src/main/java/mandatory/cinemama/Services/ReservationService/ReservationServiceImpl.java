package mandatory.cinemama.Services.ReservationService;

import java.util.List;
import mandatory.cinemama.Entities.Reservation;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.DataAccessException;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

  @Autowired
  private ReservationRepository reservationRepository;

  private String type = "Reservation";

  @Override
  public List<Reservation> findAllReservations() {
    List<Reservation> allActors = reservationRepository.findAll();
    return allActors;
  }

  @Override
  public Reservation findReservationById(Long id) {
    Reservation reservation = reservationRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    return reservation;
  }

  @Override
  public List<Reservation> findReservationsByUserId(Long id) {
    List<Reservation> reservations = reservationRepository.findByUserId(id);
    ErrorMessageCreator.throwErrorIfNotFound(reservations, id, type);
    return reservations;
  }

  @Override
  public void updateReservationById(Reservation reservation, Long id) {
    Reservation foundReservation = reservationRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );

    foundReservation.setSeats(reservation.getSeats());
    foundReservation.setPaid(reservation.isPaid());
    reservationRepository.save(foundReservation);
  }

  @Override
  public void addReservation(Reservation reservation) {
    reservationRepository.save(reservation);
  }

  @Override
  public void deleteReservationById(Long id) {
    try {
      reservationRepository.deleteById(id);
    } catch (Exception e) {
      if (e instanceof DataAccessException) {
        throw ErrorMessageCreator.throwResourceNotFoundException(id, type);
      }
    }
  }
}
