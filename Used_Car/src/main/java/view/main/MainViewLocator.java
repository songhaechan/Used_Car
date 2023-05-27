package view.main;

import dto.request.UserRequestDto;
import form.registerform.UserRegisterForm;

public class MainViewLocator {
    //첫 화면
    public void welcomeView() {
        System.out.println("<<중고차 판매시스템>>");
        System.out.println("1.회원 로그인");
        System.out.println("2.회원 가입");
        System.out.println("3.관리자 로그인");
        System.out.println("0.종료");
        System.out.print("메뉴 선택:");
    }
    //회원로그인 화면
    public void userLoginView() {
        System.out.println("<<회원 로그인>>");
    }
    //회원 가입 화면
    public UserRequestDto userRegisterView() {
        System.out.println("<<회원 가입>>");
        return UserRegisterForm.registerForm();
    }
    public void successRegisterView(){
        System.out.println("---------------------");
        System.out.println("회원가입 성공");
        System.out.println("---------------------");
    }
    //관리자 로그인 화면
    public void adminLoginView() {
        System.out.println("<<관리자 로그인>>");
    }
}
