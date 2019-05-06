package io.nai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.nai.dao.AppUserRepository;
import io.nai.entities.AppUser;
@Service
public class UserServiceImpl implements UserService<AppUser,Long >{
	@Autowired
	private AppUserRepository userRepository;
	@Override
	public List<AppUser> getAll() {
		
		return userRepository.findAll();
	}

	@Override
	public void add(AppUser user) {
		userRepository.save(user);
		
	}

	@Override
	public void update(AppUser user) {
		userRepository.save(user);
		
	}

	@Override
	public void delete(Long id) {
		AppUser user = new AppUser();
		user.setId(id);
		userRepository.delete(user);
		
	}

	@Override
	public void saveAll(Iterable<AppUser> iterable) {
		// TODO Auto-generated method stub
		
	}

}
