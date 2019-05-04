package io.nai.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.nai.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
  public AppRole findByRoleName(String roleName);
}
