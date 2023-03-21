package com.epam.jmp.controller;

import com.epam.jmp.converter.SubscriptionRequestDtoConverter;
import com.epam.jmp.converter.SubscriptionResponseDtoAssembler;
import com.epam.jmp.dto.SubscriptionRequestDto;
import com.epam.jmp.dto.SubscriptionResponseDto;
import com.epam.jmp.entity.Subscription;
import com.epam.jmp.service.SubscriptionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/subscriptions")
@Tag(name = "Subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private SubscriptionRequestDtoConverter subscriptionRequestDtoConverter;
    @Autowired
    private SubscriptionResponseDtoAssembler subscriptionResponseDtoAssembler;

    @GetMapping
    public List<SubscriptionResponseDto> getAll() {
        return subscriptionService.findAll().stream()
                .map(subscriptionResponseDtoAssembler::toModel)
                .toList();
    }

    @GetMapping("/{id}")
    public SubscriptionResponseDto getById(@PathVariable long id) {
        Subscription subscription = subscriptionService.findById(id).orElseThrow();
        return subscriptionResponseDtoAssembler.toModel(subscription);
    }

    @PostMapping
    public SubscriptionResponseDto create(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        Subscription subscription = subscriptionRequestDtoConverter.convert(subscriptionRequestDto);
        subscription = subscriptionService.save(subscription);
        return subscriptionResponseDtoAssembler.toModel(subscription);
    }

    @PatchMapping
    public SubscriptionResponseDto update(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        Subscription subscription = subscriptionRequestDtoConverter.convert(subscriptionRequestDto);
        subscription = subscriptionService.save(subscription);
        return subscriptionResponseDtoAssembler.toModel(subscription);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        subscriptionService.delete(id);
    }
}
