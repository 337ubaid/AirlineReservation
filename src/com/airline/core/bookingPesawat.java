package com.airline.core;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class tiketData{
    int pilihan;
    String tiket;

    tiketData(int pilihan) throws FileNotFoundException {
        this.pilihan = pilihan;
    }

    String getTiketData() throws IOException {
        this.tiket = Files.readAllLines(Paths.get("listTicket.txt")).get(pilihan-1);
        return this.tiket;
    }

    // Menghapus line database yang dipilih agar terupdate
    void updateDatabase(){

    }

    void displayList(){

    }

}

// Sistem transaksi
class Transaksi{

    private int saldoFinal;
    int hargaTiket;
    String dataTiket;

    Transaksi(String dataTiket){
        this.dataTiket=dataTiket;
    }

    // user ubed + assign saldo
    User ubed = new User(1000000);

    // Nanti bakal read file di split2
    int convertDataToIntHarga(String dataTiket){
        String[] hargaString = dataTiket.split(",");
        hargaTiket = Integer.parseInt(hargaString[3]);
        return hargaTiket;
    }

    // Perhitungan saldo
    void displaySaldo(){
        System.out.print("\nSaldo\t\t: " + ubed.getSaldo() + "\nHarga Tiket\t: "+convertDataToIntHarga(dataTiket)+"\nSaldo akhir\t: ");
        System.out.print(ubed.getSaldo() - convertDataToIntHarga(dataTiket));
    }


}

public class bookingPesawat {
    void viewBookingPesawat() throws IOException {
        // Memunculkan list tiket tersedia
        int i = 1;
        ListTicket listTicket = new ListTicket();
        listTicket.Tersedia();

        System.out.print("Pilih tiket: ");

        // Scanner pilihan
        Scanner inputTiket = new Scanner(System.in);
        int tiketPilihan = inputTiket.nextInt();

        // Proses pengambilan data
        tiketData beliTiket = new tiketData(tiketPilihan);

        // proses transaksi
        Transaksi transaksi = new Transaksi(beliTiket.getTiketData());
        transaksi.displaySaldo();
    }


}
