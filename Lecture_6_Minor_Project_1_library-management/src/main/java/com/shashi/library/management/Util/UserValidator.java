package com.shashi.library.management.Util;

import com.shashi.library.management.DataAccessLayer.User;

public class UserValidator {

    public boolean isValid(User user){
        if(user.getEmail().equals(null) || user.getEmail().equals("")){
            return false;
        }
        return true;
    }
}
