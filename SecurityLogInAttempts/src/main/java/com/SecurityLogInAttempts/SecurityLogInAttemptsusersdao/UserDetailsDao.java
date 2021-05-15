package com.SecurityLogInAttempts.SecurityLogInAttemptsusersdao;

import com.mkyong.users.model.UserAttempts;

public interface UserDetailsDao {

    void updateFailAttempts(String username);
    void resetFailAttempts(String username);
    UserAttempts getUserAttempts(String username);

}