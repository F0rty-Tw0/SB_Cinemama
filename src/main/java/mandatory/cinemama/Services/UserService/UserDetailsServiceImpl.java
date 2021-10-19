package mandatory.cinemama.Services.UserService;

import mandatory.cinemama.Entities.User.User;
import mandatory.cinemama.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String email)
    throws UsernameNotFoundException {
    User user = userRepository
      .findByEmail(email)
      .orElseThrow(
        () ->
          new UsernameNotFoundException(
            "User not found with the email: " + email
          )
      );
    return UserDetailsImpl.build(user);
  }
}
