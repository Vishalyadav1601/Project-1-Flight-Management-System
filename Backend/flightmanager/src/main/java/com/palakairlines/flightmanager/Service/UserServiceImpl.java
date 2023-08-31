package com.palakairlines.flightmanager.Service;

import com.palakairlines.flightmanager.Config.AppConstants;
import com.palakairlines.flightmanager.DTO.UserDTO;
import com.palakairlines.flightmanager.Model.Role;
import com.palakairlines.flightmanager.Model.Users;
import com.palakairlines.flightmanager.dao.RoleDao;
import com.palakairlines.flightmanager.dao.UserDao;
import com.palakairlines.flightmanager.Exceptions.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        Users users = this.DTOtoUser(userDTO);
        Users savedUsers = this.userDao.save(users);
        return this.UsertoDTO(savedUsers);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, BigInteger userId) {
        Users users = this.userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," Id ",userId));
        users.setUserName(userDTO.getUserName());
        users.setUserPassword(userDTO.getUserPassword());
        users.setUserPhone(userDTO.getUserPhone());
        users.setUserEmail(userDTO.getUserEmail());

        Users updateduser = this.userDao.save(users);
        UserDTO userDTO1 = this.UsertoDTO(updateduser);
        return userDTO1;

    }

    @Override
    public UserDTO getUserById(BigInteger userId) {
        Users users = this.userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User"," Id ",userId));

        return this.UsertoDTO(users);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<Users> users = this.userDao.findAll();
        List<UserDTO> userDTOS = users.stream().map(Users->UsertoDTO(Users)).collect(Collectors.toList());
        return userDTOS;
    }

    @Override
    public void deleteUser(BigInteger userId) {
        Users users = this.userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User"," Id",userId));
        this.userDao.delete(users);
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO)
    {
        Users user = this.DTOtoUser(userDTO);
        user.setUserPassword(this.passwordEncoder.encode(user.getUserPassword()));
        Role role = this.roleDao.findById(AppConstants.NORMAL_USER).get();

        user.getRoles().add(role);
        Users newUser = this.userDao.save(user);
        return this.UsertoDTO(newUser);
    }

    @Override
    public UserDTO registerAdmin(UserDTO userDTO) {
        Users user = this.DTOtoUser(userDTO);
        user.setUserPassword(this.passwordEncoder.encode(user.getUserPassword()));
        Role role = this.roleDao.findById(AppConstants.ADMIN_USER).get();

        user.getRoles().add(role);
        Users newUser = this.userDao.save(user);
        return this.UsertoDTO(newUser);
    }

    private Users DTOtoUser(UserDTO userDTO){
        Users users = this.modelMapper.map(userDTO,Users.class);
//        Users user = new Users();
//        user.setUserId(userDTO.getUserId());
//        user.setUserName(userDTO.getUserName());
//        user.setUserPassword(userDTO.getUserPassword());
//        user.setUserPhone(userDTO.getUserPhone());
//        user.setUserEmail(userDTO.getUserEmail());
        return users;
    }

    private UserDTO UsertoDTO(Users user){
        UserDTO userDTO = this.modelMapper.map(user,UserDTO.class);
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserId(user.getUserId());
//        userDTO.setUserName(user.getUserName());
//        userDTO.setUserPassword(user.getUserPassword());
//        userDTO.setUserPhone(user.getUserPhone());
//        userDTO.setUserEmail(user.getUserEmail());
        return userDTO;
    }
}

