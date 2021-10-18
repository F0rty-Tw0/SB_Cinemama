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
  private final String roles;

  public JwtResponse(
    String accessToken,
    Long id,
    String email,
    String roles
  ) {
    this.accessToken = accessToken;
    this.id = id;
    this.email = email;
    this.roles = roles;
  }
}
