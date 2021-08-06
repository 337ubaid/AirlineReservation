package com.airline.core;

public class User {
    private int saldo;

    User(int saldo) {
        this.saldo = saldo;
    }

    // Getter
    int getSaldo() {
        return saldo;
    }
    // Setter
    void setSaldo(int saldo){
        this.saldo = saldo;
    }

}