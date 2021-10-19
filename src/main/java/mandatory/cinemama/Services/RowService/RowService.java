package mandatory.cinemama.Services.RowService;

import java.util.List;
import mandatory.cinemama.Entities.Hall.HallRow.Row;

public interface RowService {
  public List<Row> findAllRows();

  public Row findRowById(Long id);

  public Row findRowByName(String name);

  public List<Row> findRowsByHallId(Long id);

  public void addRow(Row row);
}
