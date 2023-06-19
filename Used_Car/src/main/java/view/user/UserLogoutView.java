package view.user;

public class UserLogoutView implements UserMainView{
    @Override
    public boolean view(){
        System.out.println("<<로그아웃>>");
        return false;
    }
}
