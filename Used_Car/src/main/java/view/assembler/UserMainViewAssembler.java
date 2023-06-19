package view.assembler;

import view.locator.ViewLocator;
import view.user.*;

import java.util.HashMap;
import java.util.Map;

//뷰 객체를 조립
public class UserMainViewAssembler {
    private final Map<Integer, UserMainView> views = new HashMap<>();
    public ViewLocator<UserMainView> createAndWire(){
        views.put(1,new CarListView());
        views.put(2,new CarSearchView());
        views.put(3,new CarPurchaseView());
        views.put(4,new PurchaseRecordView());
        views.put(5,new AccountUpdateView());
        views.put(6,new DeleteAccountView());
        views.put(7,new UserLogoutView());
        return new ViewLocator<UserMainView>(views);
    }
}
