package com.isa.jjdzr.model;

import com.isa.jjdzr.constants.SearchAttributesEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchAttributes {
    private String keyword;
    private SearchAttributesEnum attribute;
}
