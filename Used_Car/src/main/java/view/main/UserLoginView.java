package view.main;

import dto.request.UserLoginDto;
import form.UserLoginForm;
import service.UserService;
import view.user.UserMain;

public class UserLoginView implements MainView {
    private final UserLoginForm userLoginForm = new UserLoginForm();
    private final UserService userService = new UserService();
    private final UserMain userMain = new UserMain();

    //회원로그인 화면
    @Override
    public boolean view() {
        System.out.println("<<회원 로그인>>");
        UserLoginDto loginDto = userLoginForm.loginForm();
        System.out.println(loginDto.getUserId() + "님 로그인");
        // User Main View 진입
        userMain.launchUserMainView();
        return true;
    }
}
