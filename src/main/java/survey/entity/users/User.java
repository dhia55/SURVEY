package survey.entity.users;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
@Scope("session")
public class User implements UserDetails {
  public static enum Role {USER}

  @Id
  private Long id;

  @Column(unique = true)
  private String username;
  //@JsonProperty(access = Access.WRITE_ONLY)
  private String password;
  private String role;

  private String fullName;

  private String mail;

  private String isManager;

  @JsonIgnore
  @Override
  public boolean isEnabled() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(role));
    return authorities;
  }

}
