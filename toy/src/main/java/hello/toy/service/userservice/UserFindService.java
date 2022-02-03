package hello.toy.service.userservice;

import hello.toy.dto.user.User;

public interface UserFindService {
    User findByLoginId(String loginId);
}
