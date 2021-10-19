package mandatory.cinemama.Services.AuthService;

import mandatory.cinemama.Entities.User.ERoles;
import mandatory.cinemama.Entities.User.Role;
import mandatory.cinemama.Entities.User.User;
import mandatory.cinemama.Repositories.RoleRepository;
import mandatory.cinemama.Repositories.UserRepository;
import mandatory.cinemama.Security.AuthenticationPayload.Request.LoginRequest;
import mandatory.cinemama.Security.AuthenticationPayload.Request.SignupRequest;
import mandatory.cinemama.Security.AuthenticationPayload.Response.JwtResponse;
import mandatory.cinemama.Security.AuthenticationPayload.Response.MessageResponse;
import mandatory.cinemama.Security.JWT.JwtUtils;
import mandatory.cinemama.Services.UserService.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  JwtUtils jwtUtils;

  private String ROLE_NOT_FOUND_MESSAGE = "Error: Role is not found.";

  @Override
  public ResponseEntity<?> registerUser(SignupRequest signUpRequest) {
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
        .badRequest()
        .body(new MessageResponse("Error: Email is already in use!"));
    }

    User user = new User(
      signUpRequest.getEmail(),
      passwordEncoder.encode(signUpRequest.getPassword())
    );

    String strRole = signUpRequest.getRole();
    Role role = new Role();

    if (strRole == null) {
      Role customerRole = roleRepository
        .findByName(ERoles.ROLE_CUSTOMER)
        .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_MESSAGE));
      role = customerRole;
    } else {
      switch (strRole) {
        case "admin":
          Role adminRole = roleRepository
            .findByName(ERoles.ROLE_ADMIN)
            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_MESSAGE));
          role = adminRole;
          break;
        case "manager":
          Role employeeRole = roleRepository
            .findByName(ERoles.ROLE_MANAGER)
            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_MESSAGE));
          role = employeeRole;
          break;
        case "customer":
          Role customerRole = roleRepository
            .findByName(ERoles.ROLE_CUSTOMER)
            .orElseThrow(() -> new RuntimeException(ROLE_NOT_FOUND_MESSAGE));
          role = customerRole;
          break;
      }
    }

    user.setRole(role);
    userRepository.save(user);

    return ResponseEntity.ok(
      new MessageResponse("User registered successfully!")
    );
  }

  @Override
  public ResponseEntity<JwtResponse> authenticateUser(
    LoginRequest loginRequest
  ) {
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        loginRequest.getEmail(),
        loginRequest.getPassword()
      )
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    GrantedAuthority grantedAuthority = userDetails
      .getAuthorities()
      .iterator()
      .next();
    String role = grantedAuthority.getAuthority();

    return ResponseEntity.ok(
      new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), role)
    );
  }
}
