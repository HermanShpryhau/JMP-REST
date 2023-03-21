package com.epam.jmp.converter;

import com.epam.jmp.controller.SubscriptionController;
import com.epam.jmp.controller.UserController;
import com.epam.jmp.dto.SubscriptionResponseDto;
import com.epam.jmp.entity.Subscription;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SubscriptionResponseDtoAssembler
        extends RepresentationModelAssemblerSupport<Subscription, SubscriptionResponseDto> {
    public SubscriptionResponseDtoAssembler() {
        super(SubscriptionController.class, SubscriptionResponseDto.class);
    }

    @Override
    public SubscriptionResponseDto toModel(Subscription entity) {
        SubscriptionResponseDto dto = new SubscriptionResponseDto();
        dto.setId(entity.getId());
        dto.setUserId(entity.getId());
        if (entity.getStartDate() != null){
            dto.setStartDate(entity.getStartDate().format(DateTimeFormatter.ISO_DATE));
        }

        dto.add(linkTo(methodOn(UserController.class).getById(entity.getId())).withRel("user"));

        return dto;
    }
}
