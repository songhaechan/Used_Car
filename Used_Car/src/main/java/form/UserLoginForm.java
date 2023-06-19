package form;

import dto.request.UserLoginDto;
import service.UserService;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserLoginForm {
    private String userId;
    private String userPassword;
    private final Scanner scan = new Scanner(System.in);
    private final UserService userService = new UserService();

    public UserLoginDto loginForm() {
        boolean continueFlag = true;
        while(continueFlag){
            System.out.print("아이디:");
            userId = scan.next();
            System.out.print("비밀번호:");
            userPassword = scan.next();
            try{
                userService.userLogin(userId,userPassword);
                continueFlag = false;
            }catch(NoSuchElementException e){
                System.out.println(e.getMessage());
            }
        }


        return new UserLoginDto(userId, userPassword);
    }
}
