package com.luciano.demo_park_api.controller.dto.mapper;

import com.luciano.demo_park_api.controller.dto.UserCreateDto;
import com.luciano.demo_park_api.controller.dto.UserResponseDto;
import com.luciano.demo_park_api.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static User toUser(UserCreateDto CreateDto){
        return new ModelMapper().map(CreateDto, User.class);
    }

    public static UserResponseDto toDto(User user) {
        String role = user.getRole().name().substring("ROLE_".length());
        ModelMapper mapperMain = new ModelMapper();
        TypeMap<User, UserResponseDto> propertyMapper =
                mapperMain.createTypeMap(User.class, UserResponseDto.class);
        propertyMapper.addMappings(
                mapper -> mapper.map(src -> role, UserResponseDto::setRole)
        );
        return mapperMain.map(user, UserResponseDto.class);
    };

    public static List<UserResponseDto> toListDto(List<User> users) {
        return users.stream().map(user -> toDto(user)).collect(Collectors.toList());
    }


}
