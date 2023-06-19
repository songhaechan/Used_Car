package view.main;

import dto.request.UserRegisterDto;
import form.UserRegisterForm;
import service.UserService;

public class UserRegisterView implements MainView {
    UserService userService = new UserService();
    UserRegisterForm userRegisterForm = new UserRegisterForm();

    //회원 가입 화면
    @Override
    public boolean view() {
        System.out.println("<<회원 가입>>");
        UserRegisterDto dto = userRegisterForm.registerForm();
        String name = userService.userRegister(dto);
        System.out.println("---------------------");
        System.out.println(name + "님 회원가입을 축하합니다.");
        System.out.println("---------------------");
        return true;
    }
}
