package view.user;

public class CarPurchaseView implements UserMainView{
    @Override
    public boolean view() {
        System.out.println("<<차량 구매>>");
        return true;
    }
}
