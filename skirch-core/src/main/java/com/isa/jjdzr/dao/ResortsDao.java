package com.isa.jjdzr.dao;

import com.isa.jjdzr.dto.ResortExternalDto;
import com.isa.jjdzr.mappers.ResortMapper;
import com.isa.jjdzr.model.Data;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ResortsDao {

    @Autowired
    private final ResortMapper resortMapper;
    @PersistenceContext
    EntityManager entityManager;

    public List<ResortExternalDto> getAllResorts() {
        final Query query = entityManager.createNativeQuery("SELECT * FROM skirch.resorts r", Data.class);
        List<Data> dataList = (List<Data>) query.getResultList();
        List<ResortExternalDto> list = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            list.add(resortMapper.toDto(dataList.get(i)));
        }
        return list;
    }


}
