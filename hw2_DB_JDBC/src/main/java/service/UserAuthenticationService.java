package service;

import dao.UserDao;
import dao.UserDaoJDBC;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import model.User;
import java.sql.SQLException;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@Slf4j
public class UserAuthenticationService implements Authentication {
    private UserDaoJDBC userDao;

    @Override
    public boolean isAuthenticated(String username, String inputPassword) {
        try {
            final Optional<User> optionalUser = userDaoJDBC.findByEmail(username);
            if (optionalUser.isEmpty()) return false;

            final User user = optionalUser.get();
            return user.getPassword_hash().equals(DigestUtils.md5Hex(inputPassword));
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
}
