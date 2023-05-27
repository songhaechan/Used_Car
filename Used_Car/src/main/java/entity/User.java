package entity;

import java.time.LocalDateTime;

public class User {
    //DB 기본키
    private Long userPrimaryKey;
    //회원 아이디
    private String userId;
    //회원 비밀번호
    private String userPassword;
    //회원 주소
    private String userAddress;
    //회원 이름
    private String userName;
    //회원 잔고 #9 TODO 05.26 추후 객체로 분리 고려
    private int userBalance;
    //생년월일
    private String userBirth;
    //가입 시기
    private LocalDateTime userRegistrationDate;

    //빌더패턴
    public static class Builder{
        private String userId;
        private String userPassword;
        private String userName;
        private int userBalance;
        private String userAddress;
        private String userBirth;
        private LocalDateTime userRegistrationDate;
        public User.Builder userId(String userId){this.userId = userId; return this;}
        public User.Builder userPassword(String userPassword){this.userPassword = userPassword; return this;}
        public User.Builder userName(String userName){this.userName=userName; return this;}
        public User.Builder userBalance(int userBalance){this.userBalance = userBalance;return this;}
        public User.Builder userAddress(String userAddress){this.userAddress=userAddress; return this;}
        public User.Builder userBirth(String userBirth){this.userBirth=userBirth; return this;}
        public User.Builder userRegistrationDate(LocalDateTime date){this.userRegistrationDate=date; return this;}
        public User build(){
            return new User(this);
        }
    }
    private User(User.Builder builder){
        this.userId = builder.userId;
        this.userPassword = builder.userPassword;
        this.userName = builder.userName;
        this.userBalance = builder.userBalance;
        this.userAddress = builder.userAddress;
        this.userBirth = builder.userBirth;
        this.userRegistrationDate = builder.userRegistrationDate;
    }

    public Long getUserPrimaryKey() {
        return userPrimaryKey;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public LocalDateTime getUserRegistration() {
        return userRegistrationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userPrimaryKey=" + userPrimaryKey +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userName='" + userName + '\'' +
                ", userBalance=" + userBalance +
                ", userBirth='" + userBirth + '\'' +
                ", userRegistration=" + userRegistrationDate +
                '}';
    }
}
