package com.example.stockmanagement.productservice.exception.enums;

public enum FrinedlyMessageCodes implements IFrinedlyMessageCode {
    OK(1000);
    private final int value;

    FrinedlyMessageCodes(int value) {
        this.value = value;
    }


    @Override
    public int getFrinedlyMessageCode() {
        return value;
    }
}
