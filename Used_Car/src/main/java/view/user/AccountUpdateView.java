package view.user;

public class AccountUpdateView implements UserMainView{
    @Override
    public boolean view() {
        System.out.println("<<회원 정보 수정>>");
        return true;
    }
}
