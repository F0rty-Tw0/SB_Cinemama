package mandatory.cinemama.Repositories;

import java.util.Optional;
import mandatory.cinemama.Entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
  Optional<Theater> findById(Long id);
  Optional<Theater> findByName(String name);
  Optional<Theater> findByAddress(String address);
}
