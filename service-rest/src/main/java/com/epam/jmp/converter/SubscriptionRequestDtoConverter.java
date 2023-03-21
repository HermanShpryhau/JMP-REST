package com.epam.jmp.converter;

import com.epam.jmp.dto.SubscriptionRequestDto;
import com.epam.jmp.entity.Subscription;
import com.epam.jmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionRequestDtoConverter implements Converter<SubscriptionRequestDto, Subscription> {
    @Autowired
    private UserService userService;

    @Override
    public Subscription convert(SubscriptionRequestDto source) {
        Subscription subscription = new Subscription();
        subscription.setId(source.getId());
        subscription.setUser(userService.findById(source.getUserId()).orElseThrow());
        return subscription;
    }

    @Override
    public <U> Converter<SubscriptionRequestDto, U> andThen(Converter<? super Subscription, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
