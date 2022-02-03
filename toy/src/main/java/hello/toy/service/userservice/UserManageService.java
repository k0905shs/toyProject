package hello.toy.service.userservice;

import hello.toy.dto.user.User;
import hello.toy.dto.user.UserWithdrawal;

public interface UserManageService {

    int signUp(User user);
    int withdrawal(UserWithdrawal user);

}
