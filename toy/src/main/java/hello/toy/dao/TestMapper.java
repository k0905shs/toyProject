package hello.toy.dao;

import hello.toy.dto.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestMapper {
    List<User> selectAll();
    int insertUser(User user);
    int deleteUser(Integer userId);
}
