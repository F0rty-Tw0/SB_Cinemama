package mandatory.cinemama.Controllers.AuthController;

import mandatory.cinemama.Security.Payload.Request.LoginRequest;
import mandatory.cinemama.Security.Payload.Request.SignupRequest;
import mandatory.cinemama.Security.Payload.Response.JwtResponse;
import mandatory.cinemama.Services.AuthService.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthControllerInterface {

  @Autowired
  AuthService authService;

  @Override
  public ResponseEntity<JwtResponse> authenticateUser(
    LoginRequest loginRequest
  ) {
    return authService.authenticateUser(loginRequest);
  }

  @Override
  public ResponseEntity<?> registerUser(SignupRequest signUpRequest) {
    return authService.registerUser(signUpRequest);
  }
}
