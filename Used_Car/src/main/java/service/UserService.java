package service;

import dao.user.UserDaoImpl;
import dto.request.UserLoginDto;
import dto.request.UserRegisterDto;
import entity.User;

import java.util.NoSuchElementException;


public class UserService {
    //DB 접근 객체
    UserDaoImpl userDao = UserDaoImpl.getInstance();

    //회원 가입
    public String userRegister(UserRegisterDto userDto) {
        User user = User.of(userDto);
        return userDao.addUser(user)
                .orElseThrow(NoSuchElementException::new);
    }

    //중복 ID 검증
    public String validateDuplicateUserId(String userId){
        return userDao.findByUserId(userId).orElseThrow(
                ()-> new NoSuchElementException("중복된 아이디 입니다.")
        );
    }

    //회원 로그인
    public String userLogin(String loginId, String loginPassword){
        return userDao.findByUserIdAndPassword(loginId,loginPassword)
                .orElseThrow(()-> new NoSuchElementException("아이디와 비밀번호를 확인해주세요."));
    }

    //회원 탈퇴
    public String deleteAccount(String loginId, String loginPassword){
        return userDao.deleteUser(loginId,loginPassword).orElseThrow(
                ()->new NoSuchElementException("아이디와 비밀번호를 확인해주세요")
        );
    }
}
