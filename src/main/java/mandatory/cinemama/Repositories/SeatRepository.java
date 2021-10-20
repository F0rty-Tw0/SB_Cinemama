package mandatory.cinemama.Repositories;

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

  public List<Seat> findByRowHallIdAndAvailable(Long id, Boolean available);


}
