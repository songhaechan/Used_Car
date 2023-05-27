package form.registerform;

import dto.request.UserRequestDto;

import java.util.Scanner;

public class UserRegisterForm {
    //TODO #9 05.24 registerForm() static 메서드로 MainViewLocator 에서 사용? (필드가 없는 클래스?)
    public static UserRequestDto registerForm(){
        Scanner scanner = new Scanner(System.in);
        //TODO #9 05.24 중복아이디 체크 추가
        //TODO #9 05.25 format 검증 필요(문자열길이,생년월일형식)
        System.out.print("아이디:");
        String userId = scanner.nextLine();
        System.out.print("비밀번호:");
        String userPassword = scanner.nextLine();
        System.out.print("이름:");
        String userName = scanner.nextLine();
        System.out.print("주소:");
        String userAddress = scanner.nextLine();
        System.out.print("생년월일(XXXX-XX-XX):");
        String userBirth  = scanner.nextLine();

        return new UserRequestDto.Builder()
                .userId(userId)
                .userPassword(userPassword)
                .userName(userName)
                .userAddress(userAddress)
                .userBirth(userBirth)
                .build();
    }
}
