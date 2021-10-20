package mandatory.cinemama.Repositories;

import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository
  extends JpaRepository<Reservation, Long> {
  public Optional<Reservation> findById(Long id);

  public List<Reservation> findByUserId(Long id);
}
