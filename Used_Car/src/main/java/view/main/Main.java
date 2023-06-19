package view.main;

import service.UserService;
import view.assembler.MainViewAssembler;
import view.locator.ViewLocator;

import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = new UserService();
    private final MainViewAssembler mainViewAssembler = new MainViewAssembler();
    private final ViewLocator<MainView> mainViewLocator = mainViewAssembler.createAndWire();
    private boolean continueFlag = true;

    public void launchMainView() {
        while (continueFlag) {
            welcomeView();
            int menu = scanner.nextInt();
            MainView mainView = mainViewLocator.selectMenu(menu);
            continueFlag = mainView.view();
        }
    }

    //첫 화면
    private void welcomeView() {
        System.out.println("<<중고차 판매시스템>>");
        System.out.println("1.회원 로그인");
        System.out.println("2.회원 가입");
        System.out.println("3.관리자 로그인");
        System.out.println("0.종료");
        System.out.print("메뉴 선택:");
    }
}
