import dao.UserDao;
import entity.User;
import org.junit.jupiter.api.Test;
import service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDaoTest {
    UserService userService = new UserService();
    UserDao userDao = UserDao.userDaoGetInstance();
    @Test
    void 회원가입(){
    }
}
