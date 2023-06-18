package com.isa.jjdzr.service;

import com.isa.jjdzr.dto.ResortExternalDto;
import com.isa.jjdzr.mappers.ResortMapper;
import com.isa.jjdzr.model.Data;
import com.isa.jjdzr.repositories.ResortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ResortServiceCore {


    private final ResortMapper resortMapper;

    private final ResortRepository resortRepository;

    public void saveAll(List<ResortExternalDto> listOfResorts) {
        if (resortRepository.isEmpty()) {
            resortRepository.saveAll(listOfResorts.stream()
                    .map(resortMapper::toEntity).collect(Collectors.toList()));
        }
    }
    public Data findById(Integer id) {
        return resortRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resort not found"));
    }

}
