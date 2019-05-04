package io.nai.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.nai.dao.AppUserRepository;
import io.nai.entities.AppRole;
import io.nai.entities.AppUser;
@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
    private AppUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = userRepository.findByUsername(username);
		boolean accountNonExpired=true;
		boolean credentialsNonExpired=true;
		boolean accountNonLocked=true;
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(
				username,
				user.getPassword(), 
				user.isEnable(),
				accountNonExpired,
				credentialsNonExpired,
				accountNonLocked,
				getAuthorities(user.getRoles()));
				
		return userDetails;
	}
		private Collection <? extends GrantedAuthority>getAuthorities(List<AppRole> roles) {
			Collection <GrantedAuthority>grantedAuthorities= new ArrayList<GrantedAuthority>();
			for(AppRole role:roles) {
				GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
				grantedAuthorities.add(grantedAuthority);
			}
			return grantedAuthorities;
			
		}
}
