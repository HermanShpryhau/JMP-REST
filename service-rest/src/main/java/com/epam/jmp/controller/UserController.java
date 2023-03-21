package com.epam.jmp.controller;

import com.epam.jmp.converter.UserRequestDtoConverter;
import com.epam.jmp.converter.UserResponseDtoAssembler;
import com.epam.jmp.dto.UserRequestDto;
import com.epam.jmp.dto.UserResponseDto;
import com.epam.jmp.entity.User;
import com.epam.jmp.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@Tag(name = "Users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRequestDtoConverter userRequestDtoConverter;
    @Autowired
    private UserResponseDtoAssembler userResponseDtoAssembler;

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.findAll().stream()
                .map(userResponseDtoAssembler::toModel)
                .toList();
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable long id) {
        User user = userService.findById(id).orElseThrow();
        return userResponseDtoAssembler.toModel(user);
    }

    @PostMapping
    public UserResponseDto create(@RequestBody UserRequestDto userRequestDto) {
        User user = userRequestDtoConverter.convert(userRequestDto);
        user = userService.save(user);
        return userResponseDtoAssembler.toModel(user);
    }

    @PatchMapping
    public UserResponseDto update(@RequestBody UserRequestDto userRequestDto) {
        User user = userRequestDtoConverter.convert(userRequestDto);
        user = userService.save(user);
        return userResponseDtoAssembler.toModel(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }
}
