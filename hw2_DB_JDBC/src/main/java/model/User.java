package model;
import lombok.Data;

@Data
public class User {
    private final int id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;

    public Object getPassword_hash() {
        return null;
    }
}
