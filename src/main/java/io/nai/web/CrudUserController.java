package io.nai.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nai.dao.AppRoleRepository;
import io.nai.dao.AppUserRepository;
import io.nai.entities.AppRole;
import io.nai.entities.AppUser;
import io.nai.util.RoleEnum;

@RestController
@RequestMapping("/crud_user")
public class CrudUserController extends CrudController<AppUser,Long>{
	@Autowired
	private AppRoleRepository roleRepository;
	@Autowired
	private AppUserRepository userRepository;
		
	
	public List<AppUser> getAll(){
		List<AppUser> users =super.getAll(); 
		users.forEach(user -> user.setPassword(null));
		return users;
	}
	
	
	  public void add(@RequestBody AppUser user) { AppRole role =
	  roleRepository.findByRoleName(RoleEnum.ROLE_USER.getName());
	  user.setRoles(Arrays.asList(role)); user.setEnable(true); super.add(user);
	  
	  }
	/*
	 * @PostMapping public void addUser(@RequestBody AppUser user) {
	 * userRepository.save(user); }
	 */
}
