package mandatory.cinemama.Services.UserService;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.EqualsAndHashCode;
import mandatory.cinemama.Entities.User.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@EqualsAndHashCode
public class UserDetailsImpl implements UserDetails {

  private final Long id;
  private String email;

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> grantedAuthorities;

  public UserDetailsImpl(
    Long id,
    String email,
    String password,
    Collection<? extends GrantedAuthority> grantedAuthorities
  ) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.grantedAuthorities = grantedAuthorities;
  }

  public static UserDetails build(User user) {
    List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
    grantedAuthorities.add(
      new SimpleGrantedAuthority(user.getRole().getName().name())
    );
    return new UserDetailsImpl(
      user.getId(),
      user.getEmail(),
      user.getPassword(),
      grantedAuthorities
    );
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return grantedAuthorities;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
