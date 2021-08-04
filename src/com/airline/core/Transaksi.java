package com.airline.core;

// Sistem transaksi
public class Transaksi {
    int saldoFinal;
    int hargaTiket;
    String dataTiket;

    Transaksi(String dataTiket) {
        this.dataTiket = dataTiket;
    }

    // user ubed + assign saldo
    User ubed = new User(1000000);

    // Nanti bakal read file di split2
    int convertDataToIntHarga(String dataTiket) {
        String[] hargaString = dataTiket.split(",");
        hargaTiket = Integer.parseInt(hargaString[3]);
        return hargaTiket;
    }

    // Cek jika uangnya cukup atau tidak
    boolean isBokek(int saldo, int hargaTiket){
        return saldo < hargaTiket;
    }

    boolean getIsBokek(){
        return isBokek(ubed.getSaldo(),convertDataToIntHarga(this.dataTiket));
    }

    // Perhitungan saldo
    int hitungSaldo(){
        if(!isBokek(ubed.getSaldo(),convertDataToIntHarga(this.dataTiket))){
            this.saldoFinal = ubed.getSaldo()-convertDataToIntHarga(this.dataTiket);
            ubed.setSaldo(this.saldoFinal);
            return this.saldoFinal;
        }else{
            return -1;
        }
    }

    void displaySaldo() {
        if (hitungSaldo() != -1){
            System.out.println("Saldo Anda\t: " + ubed.getSaldo());
            System.out.println("Harga tiket\t: "+ convertDataToIntHarga(this.dataTiket));
            System.out.println("Saldo akhir\t: " + saldoFinal);
        }else{
            System.out.println("SALDO ANDA TIDAK MENCUKUPI");
        }
    }
}
