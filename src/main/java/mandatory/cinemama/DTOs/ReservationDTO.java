package mandatory.cinemama.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO {

  private boolean isPaid;
  private ScheduleDTO schedule;

  @JsonIgnoreProperties("row")
  private List<SeatDTO> seats;

  @JsonIgnoreProperties("role")
  private UserDTO user;
}
