package mandatory.cinemama.Entities;

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

  @Column(nullable = false)
  @Id
  private Long movieId;

  @Column(nullable = false)
  @Id
  private Long hallId;

  @Column(nullable = false)
  @Id
  private LocalTime timeSlot;
}