package survey.service.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import survey.entity.users.RoleDigital;
import survey.entity.users.UserDigital;
public class UserDetailsPrincipal implements UserDetails {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserDigital user;
	
	public UserDetailsPrincipal(UserDigital user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<RoleDigital> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for(RoleDigital role: roles)
		{
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		//roles.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
		//return roles;
		return authorities;
	}

	public UserDigital getUser() {
		// TODO Auto-generated method stub
		return user;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getMail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


}
