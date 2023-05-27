package mapper;

import dto.request.UserRequestDto;
import entity.User;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserMapper {
    public User userDtoToEntity(UserRequestDto userDto){
        LocalDateTime date = LocalDateTime.now();
        return new User.Builder()
                .userId(userDto.getUserId())
                .userPassword(userDto.getUserPassword())
                .userName(userDto.getUserName())
                .userAddress(userDto.getUserAddress())
                // TODO #9 05.26 잔고구현필요(객체로 뺄지말지)
                .userBalance(10000000)
                .userBirth(userDto.getUserBirth())
                .userRegistrationDate(date)
                .build();
    }
}
