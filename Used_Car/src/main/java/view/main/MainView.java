package view.main;

import dto.request.UserRequestDto;
import service.UserService;

import java.util.Scanner;
import static java.lang.System.exit;

public class MainView {
    Scanner scanner = new Scanner(System.in);
    MainViewLocator mainViewLocator = new MainViewLocator();
    UserService userService = new UserService();
    public void launchMainView() {
        while(true){
            mainViewLocator.welcomeView();
            int menu = scanner.nextInt();
            switch(menu){
                //회원 로그인
                case 1:
                    mainViewLocator.userLoginView();
                    break;
                //회원 가입
                case 2:
                    UserRequestDto userDto = mainViewLocator.userRegisterView();
                    userService.userRegister(userDto);
                    mainViewLocator.successRegisterView();
                    break;
                //관리자 로그인
                case 3:
                    mainViewLocator.adminLoginView();
                    break;
                //종료
                case 0:
                    exit(1);
            }
        }
    }
}
