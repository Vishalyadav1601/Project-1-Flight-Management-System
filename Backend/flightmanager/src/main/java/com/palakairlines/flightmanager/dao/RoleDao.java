package com.palakairlines.flightmanager.dao;

import com.palakairlines.flightmanager.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Integer> {
}
