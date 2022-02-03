package hello.toy.dto.user;

import hello.toy.dto.user.auth.UserAuth;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String loginId;
    private String password;
    private String name;
    private String address;
    private UserAuth auth;

}
