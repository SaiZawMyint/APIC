package com.itech.desktopfx.annotations;

public class Driven {
    private String basePackage;

    Driven(String basePackage) {
        this.basePackage = basePackage;
    }

    public boolean checkPackage(){

        return false;
    }
}
