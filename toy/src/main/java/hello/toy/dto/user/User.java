package hello.toy.dto.user;

import lombok.Data;

@Data
public class User {

    public User(String loginId, String password, String name, String address) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    private Integer id;
    private String loginId;
    private String password;
    private String name;
    private String address;

}
