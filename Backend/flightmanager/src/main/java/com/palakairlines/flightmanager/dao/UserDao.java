package com.palakairlines.flightmanager.dao;

import com.palakairlines.flightmanager.DTO.UserDTO;
import com.palakairlines.flightmanager.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.math.BigInteger;
import java.util.Optional;

public interface UserDao extends JpaRepository<Users, BigInteger> {

    Optional<Users> findByUserName(String userName);
    boolean existsByUserName(String userName);
}
