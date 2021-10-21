package mandatory.cinemama.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

  private String email;
  private RoleDTO role;
}
