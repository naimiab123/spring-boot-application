package io.nai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nai.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	 public AppUser findByUsername(String username);
}
