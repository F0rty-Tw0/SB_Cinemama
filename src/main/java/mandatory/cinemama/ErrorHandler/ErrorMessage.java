package mandatory.cinemama.ErrorHandler;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorMessage {
  private String message;
  private String description;
  private int statusCode;
  @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
  private LocalDateTime timeStamp;
}
