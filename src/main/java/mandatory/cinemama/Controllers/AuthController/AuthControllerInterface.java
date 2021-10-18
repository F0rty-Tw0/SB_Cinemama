package mandatory.cinemama.Controllers.AuthController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import mandatory.cinemama.Security.Payload.Request.LoginRequest;
import mandatory.cinemama.Security.Payload.Request.SignupRequest;
import mandatory.cinemama.Security.Payload.Response.JwtResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "Authentication")
@RequestMapping("/api/auth")
public interface AuthControllerInterface {
  @ApiOperation("Login with your email and password")
  @PostMapping("/signin")
  public ResponseEntity<JwtResponse> authenticateUser(
    @Valid @RequestBody LoginRequest loginRequest
  );

  @ApiOperation("Sign up a new user")
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(
    @Valid @RequestBody SignupRequest signUpRequest
  );
}
