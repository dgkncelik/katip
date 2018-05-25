package com.dogukancelik.kutuphane.configuration;

public enum AuthorizationType {
    ADMIN("ADMIN"),
    USER("USER");

    private final String role;

    AuthorizationType(final String text){
        this.role = text;
    }

    @Override
    public String toString(){
        return this.role;
    }
}
