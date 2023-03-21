package com.epam.jmp.converter;

import com.epam.jmp.controller.UserController;
import com.epam.jmp.dto.UserResponseDto;
import com.epam.jmp.entity.User;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class UserResponseDtoAssembler extends RepresentationModelAssemblerSupport<User, UserResponseDto> {
    public UserResponseDtoAssembler() {
        super(UserController.class, UserResponseDto.class);
    }

    @Override
    public UserResponseDto toModel(User entity) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setBirthday(entity.getBirthday().format(DateTimeFormatter.ISO_DATE));
        return dto;
    }
}
