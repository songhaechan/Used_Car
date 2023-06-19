package view.user;

public class CarSearchView implements UserMainView{
    @Override
    public boolean view() {
        System.out.println("<<차량 조회>>");
        return true;
    }
}
