package view.user;
import service.UserService;
import view.assembler.MainViewAssembler;
import view.assembler.UserMainViewAssembler;
import view.locator.ViewLocator;
import view.main.MainView;

import java.util.Scanner;

public class UserMain {
    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = new UserService();
    private final UserMainViewAssembler userMainViewAssembler = new UserMainViewAssembler();
    private final ViewLocator<UserMainView> userMainViewLocator = userMainViewAssembler.createAndWire();
    private boolean continueFlag = true;
    public void launchUserMainView(){
        // 로그아웃 시 플래그를 다시 true 로 설정해야 회원메뉴로 재진입가능
        continueFlag = true;
        while(continueFlag){
            userMainView();
            int menu = scanner.nextInt();
            UserMainView userMainView = userMainViewLocator.selectMenu(menu);
            continueFlag = userMainView.view();
        }
    }
    private void userMainView(){
        System.out.println("<<회원 메뉴>>");
        System.out.println("1. 차량 목록");
        System.out.println("2. 차량 검색");
        System.out.println("3. 차량 구매");
        System.out.println("4. 구매 기록");
        System.out.println("5. 회원 정보 수정");
        System.out.println("6. 회원 탈퇴");
        System.out.println("7. 로그아웃");
        System.out.print("메뉴 선택:");
    }
}
