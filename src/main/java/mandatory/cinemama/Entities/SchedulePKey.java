package mandatory.cinemama.Entities;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Embeddable
@NoArgsConstructor
public class SchedulePKey implements Serializable {
  @NotNull
  private Long movieId;

  @NotNull
  private LocalTime timeSlot;
}
