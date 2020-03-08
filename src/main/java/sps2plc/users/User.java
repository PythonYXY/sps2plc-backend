package sps2plc.users;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String username;
    private String password;
}
