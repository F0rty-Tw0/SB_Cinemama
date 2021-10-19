package mandatory.cinemama.Controllers.RowController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import mandatory.cinemama.Entities.Hall.HallRow.Row;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "Rows")
@RequestMapping("/api/rows")
public interface RowControllerInterface {
  @ApiOperation("Returns all Rows available in the database")
  @GetMapping
  public List<Row> findAllRows();

  @ApiOperation("Returns the Row by Id")
  @GetMapping("/{id}")
  public Row findRowById(Long id);

  @ApiOperation("Returns the Row by Name")
  @GetMapping("/name/{name}")
  public Row findRowByName(String name);

  @ApiOperation("Returns the Rows by Hall Id")
  @GetMapping("/hall/{id}")
  public List<Row> findRowsByHallId(Long id);
}
