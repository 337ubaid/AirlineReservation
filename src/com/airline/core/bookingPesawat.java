package com.airline.core;

import java.util.Scanner;

class tiketData{
    int pilihan;
    String[] arrList;
    String tiket;

    tiketData(int pilihan, String[] arrList){
        this.pilihan = pilihan;
        this.arrList = arrList;
    }

    String getTiketData(){
        this.tiket = arrList[pilihan-1];
        return this.tiket;
    }

    // Membuat array baru setelah melakukan transaksi
    String[] listBaru(String[] arrList){
        String[] newArr = new String[arrList.length-1];
        int k = 0;
        for(int i = 0;i< arrList.length;i++){
            if(i==pilihan-1) continue;
            else{
                newArr[k] = arrList[i];
                k++;
            }
        }

        return newArr;
    }

    void displayList(){
        int i = 1;
        for(String list: listBaru(arrList)){
            System.out.println("\n"+i+". " + list);
            i++;
        }
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
        if(dataTiket == "Garuda"){
            hargaTiket = 400000;
        }else{
            return 0;
        }
        return hargaTiket;
    }

    // Perhitungan saldo
    void displaySaldo(){
        System.out.print("\nSaldo\t\t: " + ubed.getSaldo() + "\nHarga Tiket\t: "+convertDataToIntHarga(dataTiket)+"\nSaldo akhir\t: ");
        System.out.print(ubed.getSaldo() - convertDataToIntHarga(dataTiket));
    }


}

public class bookingPesawat {
    void viewBookingPesawat(){
        // Memunculkan list tiket tersedia
        int i = 1;
        for(String list: dummyList()){
            System.out.println(i+". " + list);
            i++;
        }
        System.out.print("Pilih tiket: ");

        // Scanner pilihan
        Scanner inputTiket = new Scanner(System.in);
        int tiketPilihan = inputTiket.nextInt();

        // Proses pengambilan data
        tiketData beliTiket = new tiketData(tiketPilihan, dummyList());
        beliTiket.displayList();

        // proses transaksi
        Transaksi transaksi = new Transaksi(beliTiket.getTiketData());
        transaksi.displaySaldo();
    }

    static String[] dummyList(){
        String[] tikets = {"Garuda", "Air Asia", "Batik Air"};

        return tikets;
    }
}
