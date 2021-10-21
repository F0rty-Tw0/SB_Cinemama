package mandatory.cinemama.DTOs.ImputDTOs;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationInputDTO {
  private ReservationScheduleInputDTO schedule;
  private Set<SeatInputDTO> seats;
  private UserInputDTO user;

}
