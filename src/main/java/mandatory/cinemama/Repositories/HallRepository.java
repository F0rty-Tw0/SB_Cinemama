package mandatory.cinemama.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mandatory.cinemama.Entities.Hall.Hall;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
  public Optional<Hall> findById(Long id);
  public Optional<Hall> findByName(String name);
  public List<Hall> findByTheaterId(Long id);
}
