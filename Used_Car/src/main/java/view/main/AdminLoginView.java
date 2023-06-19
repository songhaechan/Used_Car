package view.main;

public class AdminLoginView implements MainView {
    //관리자 로그인 화면
    @Override
    public boolean view() {
        System.out.println("<<관리자 로그인>>");
        return true;
    }
}
