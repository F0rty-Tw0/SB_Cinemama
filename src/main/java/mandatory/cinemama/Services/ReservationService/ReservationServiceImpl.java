package mandatory.cinemama.Services.ReservationService;

import java.util.List;
import mandatory.cinemama.DTOs.ImputDTOs.ReservationInputDTO;
import mandatory.cinemama.DTOs.ReservationDTO;
import mandatory.cinemama.Entities.Hall.Seat;
import mandatory.cinemama.Entities.Reservation;
import mandatory.cinemama.Entities.Schedule;
import mandatory.cinemama.Entities.User.User;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.DataAccessException;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.ReservationRepository;
import mandatory.cinemama.Utils.DTOConverter;
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
  public List<ReservationDTO> findReservationsByUserId(Long id) {
    List<Reservation> reservations = reservationRepository.findByUserId(id);
    ErrorMessageCreator.throwErrorIfNotFound(reservations, id, type);
    return DTOConverter.mapListDTO(reservations, ReservationDTO.class);
  }

  @Override
  public void updateReservationById(ReservationInputDTO reservation, Long id) {
    Reservation foundReservation = reservationRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );

    if (reservation.getSchedule() != null) {
      foundReservation.setSchedule(
        DTOConverter.mapDTO(reservation.getSchedule(), Schedule.class)
      );
    }

    if (reservation.getSeats() != null) {
      foundReservation.setSeats(
        DTOConverter.mapListDTO(reservation.getSeats(), Seat.class)
      );
    }
    
    if (reservation.getUser() != null) {
      foundReservation.setUser(
        DTOConverter.mapDTO(reservation.getUser(), User.class)
      );
    }
    reservationRepository.save(foundReservation);
  }

  @Override
  public void addReservation(ReservationInputDTO reservation) {
    reservationRepository.save(
      DTOConverter.mapDTO(reservation, Reservation.class)
    );
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
