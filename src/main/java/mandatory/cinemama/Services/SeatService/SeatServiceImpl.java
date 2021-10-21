package mandatory.cinemama.Services.SeatService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import mandatory.cinemama.Entities.Hall.Seat;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService {

  @Autowired
  private SeatRepository seatRepository;

  private String type = "Seat";

  @Override
  public List<Seat> findAllSeats() {
    List<Seat> allSeats = seatRepository.findAll();
    return allSeats;
  }

  @Override
  public Seat findSeatById(Long id) {
    Seat seat = seatRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    return seat;
  }

  @Override
  public Seat findSeatByName(String name) {
    Seat seat = seatRepository
      .findByName(name)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(name, type)
          )
      );
    return seat;
  }

  @Override
  public List<Seat> findSeatsByRowId(Long id) {
    List<Seat> seats = seatRepository.findByRowId(id);
    ErrorMessageCreator.throwErrorIfNotFound(seats, id, type);
    return seats;
  }

  @Override
  public List<Seat> findSeatsByRowHallId(Long id) {
    List<Seat> seats = seatRepository.findByRowHallId(id);
    ErrorMessageCreator.throwErrorIfNotFound(seats, id, type);
    return seats;
  }

  @Override
  public void addSeat(Seat seat) {
    seatRepository.save(seat);
  }

  @Override
  public List<Seat> findBookedSeats(
    Long hallId,
    LocalDate date,
    LocalTime timeSlot
  ) {
    List<Seat> seats = seatRepository.findByReservationScheduleHallIdAndReservationScheduleDateAndReservationScheduleTimeSlot(
      hallId,
      date,
      timeSlot
    );
    ErrorMessageCreator.throwErrorIfNotFound(
      seats,
      "Hall id: " + hallId + " Date: " + date + " Time Slot:" + timeSlot,
      type
    );
    return seats;
  }

  @Override
  public List<Seat> findAvailableSeats(
    Long hallId,
    LocalDate date,
    LocalTime timeSlot
  ) {
    List<Seat> seats = seatRepository.findAvailable(hallId, date, timeSlot);
    ErrorMessageCreator.throwErrorIfNotFound(
      seats,
      "Hall id: " + hallId + " Date: " + date + " Time Slot:" + timeSlot,
      type
    );
    return seats;
  }
}
