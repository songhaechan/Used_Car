package form;

import dto.request.UserRegisterDto;
import service.UserService;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserRegisterForm {
    private final UserService userService = new UserService();
    private String userId;
    private String userPassword;
    private String userName;
    private String userAddress;
    private String userBirth;
    private boolean idInvalidationFlag = true;
    private boolean formatInvalidationFlag = true;

    //입력이 들어온 값을 가져와서 처리
    public UserRegisterDto registerForm() {
        Scanner scanner = new Scanner(System.in);
        inputLoginId(scanner);
        System.out.print("비밀번호:");
        userPassword = scanner.nextLine();
        System.out.print("이름:");
        userName = scanner.nextLine();
        System.out.print("주소:");
        userAddress = scanner.nextLine();
        inputBirthDate(scanner);
        return new UserRegisterDto.Builder()
                .userId(userId)
                .userPassword(userPassword)
                .userName(userName)
                .userAddress(userAddress)
                .userBirth(userBirth)
                .build();
    }

    private void inputLoginId(Scanner scanner) {
        while (idInvalidationFlag) {
            System.out.print("아이디:");
            userId = scanner.nextLine();
            try {
                userService.validateDuplicateUserId(userId);
                idInvalidationFlag = false;
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                idInvalidationFlag = true;
            }
        }
    }

    private void inputBirthDate(Scanner scanner) {
        while (formatInvalidationFlag) {
            System.out.print("생년월일(ex:19990222):");
            userBirth = scanner.nextLine();
            if (isNotValidateFormat(userBirth))
                System.out.println("8자로 입력해주세요.");
            formatInvalidationFlag = false;
        }
    }

    //생년월일 형식 검증
    private boolean isNotValidateFormat(String birth) {
        int DATE_FORMAT = 8;
        return birth.length() != DATE_FORMAT;
    }
}
