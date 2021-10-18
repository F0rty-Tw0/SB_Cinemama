package mandatory.cinemama.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mandatory.cinemama.Entities.Hall.HallRow.Row;

public interface RowRepository extends JpaRepository<Row, Long> {
  public Optional<Row> findById(Long id);

  public Optional<Row> findByName(String name);

  public List<Row> findByHallId(Long id);
}
