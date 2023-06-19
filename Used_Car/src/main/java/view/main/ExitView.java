package view.main;

public class ExitView implements MainView {
    @Override
    public boolean view() {
        System.out.println("종료");
        return false;
    }
}
