package mandatory.cinemama.Security.AuthenticationPayload.Response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtResponse {

  private String accessToken;
  private String tokenType = "Bearer";
  private Long id;
  private String email;
  private final String role;

  public JwtResponse(
    String accessToken,
    Long id,
    String email,
    String role
  ) {
    this.accessToken = accessToken;
    this.id = id;
    this.email = email;
    this.role = role;
  }
}
