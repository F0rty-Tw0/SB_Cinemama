package mandatory.cinemama.ErrorHandler;

import java.time.LocalDateTime;
import mandatory.cinemama.ErrorHandler.Exceptions.DataAccessException;
import mandatory.cinemama.ErrorHandler.Exceptions.EntityNotFoundException;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorHandlerController {

  private ErrorMessage createErrorMessage(
    String errorMessage,
    HttpStatus httpStatus,
    WebRequest request
  ) {
    return new ErrorMessage(
      errorMessage,
      request.getDescription(false),
      httpStatus.value(),
      LocalDateTime.now()
    );
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorMessage> handleResourceNotFound(
    ResourceNotFoundException error,
    WebRequest request
  ) {
    HttpStatus httpStatus = HttpStatus.NOT_FOUND;
    return new ResponseEntity<ErrorMessage>(
      createErrorMessage(error.getMessage(), httpStatus, request),
      httpStatus
    );
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ErrorMessage> entityNotFoundException(
    EntityNotFoundException error,
    WebRequest request
  ) {
    HttpStatus httpStatus = HttpStatus.NOT_FOUND;
    return new ResponseEntity<ErrorMessage>(
      createErrorMessage(error.getMessage(), httpStatus, request),
      httpStatus
    );
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessage> globalExceptionHandler(
    Exception error,
    WebRequest request
  ) {
    HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    return new ResponseEntity<ErrorMessage>(
      createErrorMessage(error.getMessage(), httpStatus, request),
      httpStatus
    );
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<ErrorMessage> dataIntegrityViolationException(
    DataIntegrityViolationException error,
    WebRequest request
  ) {
    HttpStatus httpStatus = HttpStatus.CONFLICT;

    return new ResponseEntity<ErrorMessage>(
      createErrorMessage(
        error.getRootCause().getMessage(),
        httpStatus,
        request
      ),
      httpStatus
    );
  }

  @ExceptionHandler(DataAccessException.class)
  public ResponseEntity<ErrorMessage> emptyResultDataAccessException(
    DataAccessException error,
    WebRequest request
  ) {
    HttpStatus httpStatus = HttpStatus.NOT_FOUND;
    return new ResponseEntity<ErrorMessage>(
      createErrorMessage(error.getMessage(), httpStatus, request),
      httpStatus
    );
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorMessage> illegalArgumentException(
    IllegalArgumentException error,
    WebRequest request
  ) {
    HttpStatus httpStatus = HttpStatus.NOT_FOUND;
    return new ResponseEntity<ErrorMessage>(
      createErrorMessage(error.getMessage(), httpStatus, request),
      httpStatus
    );
  }
}
