package mandatory.cinemama.Services.AuthService;

import mandatory.cinemama.Security.Payload.Request.LoginRequest;
import mandatory.cinemama.Security.Payload.Request.SignupRequest;
import mandatory.cinemama.Security.Payload.Response.JwtResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
  public ResponseEntity<?> registerUser(SignupRequest signUpRequest);

  public ResponseEntity<JwtResponse> authenticateUser(
    LoginRequest loginRequest
  );
}
