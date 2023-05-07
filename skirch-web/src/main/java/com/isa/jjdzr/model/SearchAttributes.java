package com.isa.jjdzr.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchAttributes {
    private String keyword;
    private String endpoint;
}
