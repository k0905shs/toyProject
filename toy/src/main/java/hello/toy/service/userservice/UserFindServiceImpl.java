package hello.toy.service.userservice;

import hello.toy.dao.UserMapper;
import hello.toy.dto.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserFindServiceImpl implements UserFindService{

    private final UserMapper userMapper;

    @Override
    public User findByLoginId(String loginId) {
        return userMapper.selectByLoginId(loginId);
    }
}

