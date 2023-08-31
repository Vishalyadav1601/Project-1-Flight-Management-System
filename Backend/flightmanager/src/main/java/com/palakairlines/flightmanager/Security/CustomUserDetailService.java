package com.palakairlines.flightmanager.Security;

import com.palakairlines.flightmanager.Exceptions.NameResourceNotFoundException;
import com.palakairlines.flightmanager.Model.Users;
import com.palakairlines.flightmanager.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.userDao.findByUserName(username).orElseThrow(()->new NameResourceNotFoundException("User","Name","username"));
        return user;
    }
}
