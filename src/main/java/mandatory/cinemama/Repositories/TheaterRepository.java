package mandatory.cinemama.Repositories;

import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository
  extends JpaRepository<Theater, Long> {
  List<Theater> findAll();
  Optional<Theater> findById(Long id);
  Optional<Theater> findTheaterByName(String name);
  Optional<Theater> findTheaterByAddress(String address);
}
