package mandatory.cinemama.Repositories;

import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
  public Optional<Theater> findById(Long id);

  public List<Theater> findByNameContaining(String name);

  public List<Theater> findByAddressContaining(String address);
}
