package mandatory.cinemama.Services.AuthService;

import org.springframework.http.ResponseEntity;

import mandatory.cinemama.Security.AuthenticationPayload.Request.LoginRequest;
import mandatory.cinemama.Security.AuthenticationPayload.Request.SignupRequest;
import mandatory.cinemama.Security.AuthenticationPayload.Response.JwtResponse;

public interface AuthService {
  public ResponseEntity<?> registerUser(SignupRequest signUpRequest);

  public ResponseEntity<JwtResponse> authenticateUser(
    LoginRequest loginRequest
  );
}
