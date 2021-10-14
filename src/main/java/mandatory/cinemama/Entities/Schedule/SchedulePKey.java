package mandatory.cinemama.Entities.Schedule;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SchedulePKey implements Serializable {

  @Id
  @Column(nullable = false)
  private Long movieId;

  @Id
  @Column(nullable = false)
  private Long hallId;

  @Id
  @Column(nullable = false)
  private LocalTime timeSlot;
}