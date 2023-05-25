package com.isa.jjdzr.service;

import com.isa.jjdzr.mappers.ResortMapper;
import com.isa.jjdzr.model.ResortExternalDto;
import com.isa.jjdzr.repositories.ResortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isa.jjdzr.model.Data;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ResortServiceCore {

    @Autowired
    private final ResortMapper resortMapper;

    @Autowired
    private final ResortRepository resortRepository;

    public void saveAll(List<ResortExternalDto> listOfResorts){
        for (int i = 0; i < listOfResorts.size(); i++) {
            Data resortEntity = resortMapper.toEntity(listOfResorts.get(i));
            resortRepository.save(resortEntity);
        }
    }
}
