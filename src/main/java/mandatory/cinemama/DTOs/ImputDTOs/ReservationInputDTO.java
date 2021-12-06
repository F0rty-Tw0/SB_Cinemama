package mandatory.cinemama.DTOs.ImputDTOs;

import java.util.List;

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
  private List<SeatInputDTO> seats;
  private UserInputDTO user;

}
