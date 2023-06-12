package com.isa.jjdzr.mappers;

import com.isa.jjdzr.model.Data;
import com.isa.jjdzr.dto.ResortExternalDto;

public interface ResortMapper {
    Data toEntity(ResortExternalDto resortExternalDto);
    ResortExternalDto toDto(Data data);
}
