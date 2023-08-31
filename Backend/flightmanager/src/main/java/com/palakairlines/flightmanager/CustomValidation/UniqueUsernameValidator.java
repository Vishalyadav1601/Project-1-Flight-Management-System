package com.palakairlines.flightmanager.CustomValidation;

import com.palakairlines.flightmanager.dao.UserDao;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private final UserDao userDao;

    public UniqueUsernameValidator(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {
        return userName != null && !userDao.existsByUserName(userName);
    }
}