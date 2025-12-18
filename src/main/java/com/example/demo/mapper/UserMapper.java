package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.demo.dto.request.UserRegisterRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Request → Entity
    @Mapping(target = "password", ignore = true)
    User toEntity(UserRegisterRequest request);

    // Entity → Response
    UserResponse toResponse(User user);
}
