package com.palakairlines.flightmanager.Service;

import com.palakairlines.flightmanager.DTO.UserDTO;


import java.math.BigInteger;
import java.util.List;


public interface UserService {

    UserDTO registerUser(UserDTO userDTO);
    UserDTO registerAdmin(UserDTO userDTO);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO, BigInteger userId);
    UserDTO getUserById(BigInteger userId);
    List<UserDTO> getAllUsers();
    void deleteUser(BigInteger userId);

}
