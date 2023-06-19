package dto.request;

public class UserRegisterDto {
    //회원 아이디
    private final String userId;
    //회원 비밀번호
    private final String userPassword;
    //회원 이름
    private final String userName;
    //회원 주소
    private final String userAddress;
    //생년월일
    private final String userBirth;

    //빌더패턴
    public static class Builder {
        private String userId;
        private String userPassword;
        private String userName;
        private String userAddress;
        private String userBirth;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder userPassword(String userPassword) {
            this.userPassword = userPassword;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder userAddress(String userAddress) {
            this.userAddress = userAddress;
            return this;
        }

        public Builder userBirth(String userBirth) {
            this.userBirth = userBirth;
            return this;
        }

        public UserRegisterDto build() {
            return new UserRegisterDto(this);
        }
    }

    private UserRegisterDto(Builder builder) {
        this.userId = builder.userId;
        this.userPassword = builder.userPassword;
        this.userName = builder.userName;
        this.userAddress = builder.userAddress;
        this.userBirth = builder.userBirth;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserBirth() {
        return userBirth;
    }
}
