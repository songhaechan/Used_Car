package service;

import dao.UserDao;
import dto.request.UserRequestDto;
import entity.User;
import mapper.UserMapper;

public class UserService {
    //DB 접근 객체
    UserDao userDao = UserDao.userDaoGetInstance();
    //Dto - > Entity | Entity - > Dto
    UserMapper userMapper = new UserMapper();

    //회원등록 TODO 05.26 Boolean 을 반환할지 User 를 반환할지 고민
    public Long userRegister(UserRequestDto userDto) {
        User user = userMapper.userDtoToEntity(userDto);
        return userDao.addUser(user);
    }
}
