package io.nai.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nai.entities.AppUser;
import io.nai.service.UserService;

@RestController
@RequestMapping("/crud_user")
public class CrudUserController {
	@Autowired
	private UserService<AppUser, Long> userService;
	
	@GetMapping
	public List<AppUser> getAll(){
		return userService.getAll();
	}
    
	@PostMapping
	public void add(@RequestBody AppUser user) {
		userService.add(user);
	}
	@PutMapping
	public void update(@RequestBody AppUser user) {
		userService.update(user);
	}
	
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}
}
