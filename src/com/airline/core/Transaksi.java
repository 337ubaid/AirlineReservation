package com.airline.core;

import java.io.IOException;

// Sistem transaksi
public class Transaksi {
    int saldoFinal;
    int hargaTiket;
    String dataTiket;


    Transaksi(String dataTiket) {
        this.dataTiket = dataTiket;
    }


    // Nanti bakal read file di split2
    int convertDataToIntHarga(String dataTiket, int index) {
        String[] hargaString = dataTiket.split(",");
        hargaTiket = Integer.parseInt(hargaString[index]);
        return hargaTiket;
    }

    // Cek jika uangnya cukup atau tidak
    boolean isBokek(int saldo, int hargaTiket){
        return saldo < hargaTiket;
    }


    // Perhitungan saldo dikurangi harga tiket
    int hitungSaldo(User userData) throws IOException {

        if(!isBokek(userData.getSaldo(),convertDataToIntHarga(this.dataTiket,3))){
            this.saldoFinal = userData.getSaldo()-convertDataToIntHarga(this.dataTiket,3);
//            user.setSaldo(this.saldoFinal);
            return this.saldoFinal;
        }else{
            return -1;
        }
    }


}
