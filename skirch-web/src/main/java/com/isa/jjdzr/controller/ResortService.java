package com.isa.jjdzr.controller;

import com.isa.jjdzr.dto.Resort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResortService {
    String resortName() {
        return "nasz resort";
    }
    List<String> resortList() {
        return List.of("a", "b", "c");
    }
    Resort resort(){
        return new Resort("HOTEL");
    }
}
