package com.isa.jjdzr.mappers;

import com.isa.jjdzr.dto.UserDto;
import com.isa.jjdzr.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
}
