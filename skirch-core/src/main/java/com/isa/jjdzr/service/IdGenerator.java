package com.isa.jjdzr.service;

public class IdGenerator {
    private static int currentMaxId = 0;
    public static int generateNewId() {
        return ++currentMaxId;
    }
}
