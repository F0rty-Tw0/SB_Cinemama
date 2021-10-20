package mandatory.cinemama.Controllers.AuthController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import mandatory.cinemama.Security.AuthenticationPayload.Request.LoginRequest;
import mandatory.cinemama.Security.AuthenticationPayload.Request.SignupRequest;
import mandatory.cinemama.Security.AuthenticationPayload.Response.JwtResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(
  tags = "Authentication - (REQUIRED)",
  description = "- An endpoint for <b>Login</b> and <b>SignUp</b>"
)
@RequestMapping("/api/auth")
public interface AuthControllerInterface {
  @ApiOperation(
    value = " - Login with your Email and Password",
    notes = "After successful login, you will receive a signed <b>JWT</b>. Copy it and use it to authorize your account."
  )
  @PostMapping("/login")
  public ResponseEntity<JwtResponse> authenticateUser(
    @Valid @RequestBody LoginRequest loginRequest
  );

  @ApiOperation(
    value = " - Sign up a as a new User",
    notes = "In order to create a new <b>User</b>, you need an Email and Password. <em>(<b>Role</b> is optional)</em>."
  )
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(
    @Valid @RequestBody SignupRequest signUpRequest
  );
}
