package view.user;

public class PurchaseRecordView implements UserMainView{
    @Override
    public boolean view() {
        System.out.println("<<구매 기록>>");
        return true;
    }
}
