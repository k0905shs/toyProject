package hello.toy.dao;

import hello.toy.dto.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectAll();
    int insertUser(User user);
    int deleteUser(Integer userId);
    User selectByLoginId(String loginId);
}
