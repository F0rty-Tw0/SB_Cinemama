package mandatory.cinemama.Controllers.RowController;

import java.util.List;
import mandatory.cinemama.Entities.Hall.HallRow.Row;
import mandatory.cinemama.Services.RowService.RowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RowController implements RowControllerInterface {

  @Autowired
  private RowService rowService;

  @Override
  public List<Row> findAllRows() {
    return rowService.findAllRows();
  }

  @Override
  public Row findRowById(Long id) {
    return rowService.findRowById(id);
  }

  @Override
  public Row findRowByName(String name) {
    return rowService.findRowByName(name);
  }

  @Override
  public List<Row> findRowsByHallId(Long id) {
    return rowService.findRowsByHallId(id);
  }
}
