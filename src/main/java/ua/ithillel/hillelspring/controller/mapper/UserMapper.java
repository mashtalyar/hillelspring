package ua.ithillel.hillelspring.controller.mapper;

import org.springframework.stereotype.Component;
import ua.ithillel.hillelspring.controller.dto.UserDto;
import ua.ithillel.hillelspring.entity.User;
@Component
public class UserMapper {
    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getAge(),
                user.getEmail(),
                user.getPhone()
        );
    }

    public User toEntity(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getAge(),
                userDto.getEmail(),
                userDto.getPhone()
        );
    }
}
