package view.user;

public class CarListView implements UserMainView{
    @Override
    public boolean view() {
        System.out.println("<<차량 목록>>");
        return true;
    }
}
