package form;

import service.UserService;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserDeleteForm {
    private String userLoginId;
    private String userLoginPassword;
    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = new UserService();
    private boolean continueFlag = true;
    public void deleteForm(){
        while(continueFlag){
            System.out.print("아이디:");
            userLoginId = scanner.nextLine();
            System.out.print("비밀번호:");
            userLoginPassword = scanner.nextLine();
            try{
                userService.deleteAccount(userLoginId,userLoginPassword);
                continueFlag = false;
            }catch(NoSuchElementException e){
                System.out.println(e.getMessage());
                continueFlag = true;
            }
        }

    }
}
