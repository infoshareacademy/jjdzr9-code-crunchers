package com.isa.jjdzr.mappers;

import com.isa.jjdzr.model.Data;
import com.isa.jjdzr.dto.ResortExternalDto;
import org.springframework.stereotype.Component;

@Component
public class ResortMapperImpl implements ResortMapper {

    @Override
    public Data toEntity(ResortExternalDto resortExternalDto) {
        if (resortExternalDto == null) {
            return null;
        }

        Data data = new Data();
        data.setCountry(resortExternalDto.getData().getCountry());
        data.setRegion(resortExternalDto.getData().getRegion());
        data.setHref(resortExternalDto.getData().getHref());
        data.setName(resortExternalDto.getData().getName());
        data.setId(resortExternalDto.getData().getId());
        data.setLocation(resortExternalDto.getData().getLocation());
        data.setLifts(resortExternalDto.getData().getLifts());

        return data;
    }

    @Override
    public ResortExternalDto toDto(Data data) {
        if(data == null) {
            return null;
        }
        ResortExternalDto resortExternalDto = new ResortExternalDto();
        resortExternalDto.setData(data);
        return resortExternalDto;
    }
}
