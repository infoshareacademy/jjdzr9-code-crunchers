package com.isa.jjdzr.mappers;

import com.isa.jjdzr.model.Data;
import com.isa.jjdzr.model.ResortExternalDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResortMapper {
    Data toEntity(ResortExternalDto resortExternalDto);
    ResortExternalDto toDto(Data data);
}
