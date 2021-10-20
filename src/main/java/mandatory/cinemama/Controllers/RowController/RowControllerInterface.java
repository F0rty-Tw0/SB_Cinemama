package mandatory.cinemama.Controllers.RowController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import java.util.List;
import mandatory.cinemama.Entities.Hall.HallRow.Row;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(
  tags = "Rows",
  description = "- (OPTIONAL) A secured endpoint for <b>Rows</b>, requires a role of <b>ADMIN</b> to operate! - <em>(This endpoint was created for the testing and learning purposes only).</em>"
)
@RequestMapping("/api/rows")
public interface RowControllerInterface {
  @ApiOperation(
    value = " - Returns all Rows available in the database",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Execute to retrieve all <b>Rows</b>."
  )
  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public List<Row> findAllRows();

  @ApiOperation(
    value = " - Returns the Row by Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>id</b> of a Row to retrieve a <b>Row</b> Object."
  )
  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public Row findRowById(Long id);

  @ApiOperation(
    value = " - Returns the Row by Name",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Name</b> of a Row to retrieve a <b>Row</b> Object."
  )
  @GetMapping("/name/{name}")
  @PreAuthorize("hasRole('ADMIN')")
  public Row findRowByName(String name);

  @ApiOperation(
    value = " - Returns the Rows by Hall Id",
    authorizations = { @Authorization(value = "jwtToken") },
    notes = "Enter the <b>Hall Id</b> of a Hall to retrieve a list of <b>Rows</b>."
  )
  @GetMapping("/hall/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public List<Row> findRowsByHallId(Long id);
}
