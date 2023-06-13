package com.isa.jjdzr.service;

import com.isa.jjdzr.mappers.ResortMapper;
import com.isa.jjdzr.model.Data;
import com.isa.jjdzr.dto.ResortExternalDto;
import com.isa.jjdzr.repositories.ResortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ResortServiceCore {


    private final ResortMapper resortMapper;

    private final ResortRepository resortRepository;

    public void saveAll(List<ResortExternalDto> listOfResorts){
        for (int i = 0; i < listOfResorts.size(); i++) {
            Data resortEntity = resortMapper.toEntity(listOfResorts.get(i));
            resortRepository.save(resortEntity);
        }
    }
    public Data findById(Integer id) {
        return resortRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resort not found"));
    }

}
