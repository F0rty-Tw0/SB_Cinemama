package mandatory.cinemama.Repositories;

import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
  Optional<Hall> findById(Long id);
  Optional<Hall> findByName(String name);
  List<Hall> findByTheaterId(Long id);
}
