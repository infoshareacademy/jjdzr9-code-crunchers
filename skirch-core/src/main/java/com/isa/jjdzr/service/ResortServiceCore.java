package com.isa.jjdzr.service;

import com.isa.jjdzr.mappers.ResortMapper;
import com.isa.jjdzr.model.Data;
import com.isa.jjdzr.model.ResortExternalDto;
import com.isa.jjdzr.repositories.ResortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            System.out.println(listOfResorts.get(i));
            Data resortEntity = resortMapper.toEntity(listOfResorts.get(i));
            System.out.println("============================");
            System.out.println(resortEntity);
            resortRepository.save(resortEntity);
        }
    }


}
