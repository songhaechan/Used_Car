import dao.user.UserDaoImpl;
import dto.request.UserLoginDto;
import dto.request.UserRegisterDto;
import entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.UserService;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserServiceTest {
    // TODO 06.17 테스트코드에 중복이 너무 많다.

    UserService userService = new UserService();
    UserDaoImpl userDao = UserDaoImpl.getInstance();

    @DisplayName("회원데이터를 DB에 INSERT 후 같은 이름이 같으면 성공")
    @Test
    void 회원가입(){
        //given
        UserRegisterDto inputData = new UserRegisterDto.Builder()
                .userId("userId")
                .userPassword("userPassword")
                .userName("userName")
                .userAddress("userAddress")
                .userBirth("userBirth")
                .build();
        User user = User.of(inputData);
        //when
        userDao.addUser(user);
        //then
        assertEquals(user.getUserName(),user.getUserName());
        Assertions.assertThat(user.getUserName()).isEqualTo("userName");
    }

    @Test
    @DisplayName("회원가입된 로그인 ID와 입력된 로그인 ID가 같은면 성공")
    void 로그인(){
        //give
        UserRegisterDto inputData = new UserRegisterDto.Builder()
                .userId("userId")
                .userPassword("userPassword")
                .userName("userName")
                .userAddress("userAddress")
                .userBirth("userBirth")
                .build();
        User user = User.of(inputData);
        UserLoginDto dto = new UserLoginDto("userId","userPassword");
        //when
        Optional<String> result = userDao.findByUserIdAndPassword(dto.getUserId(),dto.getUserPassword());
        //then
        Assertions.assertThat(inputData.getUserName()).isEqualTo(result.orElseThrow(NoSuchElementException::new));
    }
    
    @Test
    @DisplayName("DB에 존재하는 로그인 ID 라면 예외 발생")
    public void 중복아이디_검증(){
        //given
        회원가입();
        //then
        Assertions.assertThatThrownBy(()->userService.validateDuplicateUserId("userId"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("DB에 존재하는 회원정보와 맞지않을때 탈퇴가 실패")
    public void 회원탈퇴_실패(){
        //given
        회원가입();
        //then
        Assertions.assertThatThrownBy(()->userService.deleteAccount("user","user"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("회원탈퇴 후엔 로그인이 실패해야한다.")
    public void 회원탈퇴_성공(){
        //given
        UserRegisterDto inputData = new UserRegisterDto.Builder()
                .userId("userId")
                .userPassword("userPassword")
                .userName("userName")
                .userAddress("userAddress")
                .userBirth("userBirth")
                .build();
        User user = User.of(inputData);
        userDao.addUser(user);
        //when
        userService.deleteAccount("userId","userPassword");
        //then
        Assertions.assertThatThrownBy(()->userService.userLogin("userId","userPassword"))
                .isInstanceOf(NoSuchElementException.class);
    }
}
