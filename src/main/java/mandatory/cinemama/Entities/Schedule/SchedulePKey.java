package mandatory.cinemama.Entities.Schedule;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class SchedulePKey implements Serializable {

  private LocalTime timeSlot;

  private LocalDate date;

  private Long hallId;

  private Long movieId;
}
