package dto.request;

public class UserLoginDto {

    private final String userId;
    private final String userPassword;

    public UserLoginDto(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
