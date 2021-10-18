package mandatory.cinemama.Security.AuthenticationPayload.Request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequest {

  @NotBlank
  @Size(max = 120)
  @Email
  private String email;

  private String role;

  @NotBlank
  @Size(min = 4, max = 50)
  private String password;
}
