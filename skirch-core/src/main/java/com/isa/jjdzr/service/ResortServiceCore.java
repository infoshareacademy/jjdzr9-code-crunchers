package com.isa.jjdzr.service;

import com.isa.jjdzr.dto.ResortExternalDto;
import com.isa.jjdzr.mappers.ResortMapper;
import com.isa.jjdzr.repositories.ResortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ResortServiceCore {

    @Autowired
    private final ResortMapper resortMapper;
    @Autowired
    private final ResortRepository resortRepository;

    public void saveAll(List<ResortExternalDto> listOfResorts) {
        if (resortRepository.isEmpty()) {
            resortRepository.saveAll(listOfResorts.stream()
                    .map(resortMapper::toEntity).collect(Collectors.toList()));
        }
    }


}
