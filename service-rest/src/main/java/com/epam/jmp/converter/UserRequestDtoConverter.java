package com.epam.jmp.converter;

import com.epam.jmp.dto.UserRequestDto;
import com.epam.jmp.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserRequestDtoConverter implements Converter<UserRequestDto, User> {
    @Override
    public User convert(UserRequestDto source) {
        User user = new User();
        user.setId(source.getId());
        user.setName(source.getName());
        user.setSurname(source.getSurname());
        user.setBirthday(LocalDate.parse(source.getBirthday()));
        return user;
    }

    @Override
    public <U> Converter<UserRequestDto, U> andThen(Converter<? super User, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
