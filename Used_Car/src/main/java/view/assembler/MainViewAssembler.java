package view.assembler;

import view.locator.ViewLocator;
import view.main.*;

import java.util.HashMap;
import java.util.Map;

//뷰 객체를 조립
public class MainViewAssembler {
    private final Map<Integer, MainView> views = new HashMap<>();
    public ViewLocator<MainView> createAndWire(){
        views.put(1,new UserLoginView());
        views.put(2,new UserRegisterView());
        views.put(3,new AdminLoginView());
        views.put(0,new ExitView());
        return new ViewLocator<MainView>(views);
    }
}
