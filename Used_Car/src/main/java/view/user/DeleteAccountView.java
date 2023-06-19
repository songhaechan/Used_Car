package view.user;

import form.UserDeleteForm;

public class DeleteAccountView implements UserMainView{
    @Override
    public boolean view() {
        UserDeleteForm userDeleteForm = new UserDeleteForm();
        System.out.println("<<회원 탈퇴>>");
        userDeleteForm.deleteForm();
        return false;
    }
}
