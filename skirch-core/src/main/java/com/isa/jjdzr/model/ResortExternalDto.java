package com.isa.jjdzr.model;
@lombok.Data
public class ResortExternalDto {
    private Data data;

    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }
}
