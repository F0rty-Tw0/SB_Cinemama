package mandatory.cinemama.Services.RowService;

import java.util.List;
import mandatory.cinemama.Entities.Hall.HallRow.Row;
import mandatory.cinemama.ErrorHandler.ErrorMessageCreator;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import mandatory.cinemama.Repositories.RowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RowServiceImpl implements RowService {

  @Autowired
  private RowRepository rowRepository;

  private String type = "Rows";

  @Override
  public List<Row> findAllRows() {
    List<Row> allRows = rowRepository.findAll();
    ErrorMessageCreator.throwErrorIfNotFound(allRows, "of All", type);
    return allRows;
  }

  @Override
  public Row findRowById(Long id) {
    Row genre = rowRepository
      .findById(id)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(id, type)
          )
      );
    return genre;
  }

  @Override
  public Row findRowByName(String name) {
    Row genre = rowRepository
      .findByName(name)
      .orElseThrow(
        () ->
          new ResourceNotFoundException(
            ErrorMessageCreator.NotFoundErrorMessage(name, type)
          )
      );
    return genre;
  }

  @Override
  public List<Row> findRowsByHallId(Long id) {
    List<Row> rows = rowRepository.findByHallId(id);
    ErrorMessageCreator.throwErrorIfNotFound(rows, id, type);
    return rows;
  }

  @Override
  public void addRow(Row row) {
    rowRepository.save(row);
  }
}
