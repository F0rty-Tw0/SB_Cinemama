package mandatory.cinemama.ErrorHandler;

import java.util.List;
import java.util.Optional;
import mandatory.cinemama.ErrorHandler.Exceptions.ResourceNotFoundException;

public class ErrorMessageCreator {

  public static <T> String NotFoundErrorMessage(T search, String type) {
    return ("Could not find the " + type + " by the query: " + search);
  }

  public static <T> String DataIntegrityViolationErrorMessage(
    String type,
    String message
  ) {
    return (
      "Could not execute your on " + type + "input because of : " + message
    );
  }

  public static <T> ResourceNotFoundException throwResourceNotFoundException(
    T query,
    String type
  ) {
    throw new ResourceNotFoundException(NotFoundErrorMessage(query, type));
  }

  public static <T, B> void throwErrorIfNotFound(T obj, B query, String type) {
    if (
      obj instanceof List<?> &&
      ((List<?>) obj).size() == 0 ||
      obj instanceof Optional<?> &&
      ((Optional<?>) obj).isEmpty() ||
      obj == null
    ) {
      throw new ResourceNotFoundException(NotFoundErrorMessage(query, type));
    }
  }
}
