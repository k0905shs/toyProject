package hello.toy.service.userservice;

import hello.toy.dao.UserMapper;
import hello.toy.dto.user.User;
import hello.toy.dto.user.UserWithdrawal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserManageServiceImpl implements UserManageService{

    private final UserMapper userMapper;
    
    @Override
    public int signUp(User user) {
        //검증 로직
        return 0;
    }

    @Override
    public int withdrawal(UserWithdrawal user) {
        //검증 로직
        return 0;
    }
}
