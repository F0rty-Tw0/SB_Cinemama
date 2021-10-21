package mandatory.cinemama.Repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Hall.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeatRepository extends JpaRepository<Seat, Long> {
  public Optional<Seat> findById(Long id);

  public Optional<Seat> findByName(String name);

  public List<Seat> findByRowId(Long id);

  public List<Seat> findByRowHallId(Long id);

  public List<Seat> findByReservationScheduleHallIdAndReservationScheduleDateAndReservationScheduleTimeSlot(
    Long id,
    LocalDate date,
    LocalTime timeSlot
  );

  @Query(
    "SELECT DISTINCT seat FROM Seat seat WHERE seat.row.hall.id = :hallId AND NOT EXISTS" +
    "(SELECT reserved_seat FROM Seat reserved_seat JOIN reserved_seat.reservation AS sr WHERE reserved_seat.id = seat.id AND sr.schedule.date = :date AND sr.schedule.timeSlot = :timeSlot AND sr.schedule.hall.id = :hallId)"
  )
  public List<Seat> findAvailable(
    Long hallId,
    LocalDate date,
    LocalTime timeSlot
  );
}
