package com.airline.core;

import java.io.*;
import java.util.Scanner;

public class bookingPesawat {
    void viewBookingPesawat() throws IOException {
        // Memunculkan list tiket tersedia
        int i = 1;
        ListTicket listTicket = new ListTicket();
        listTicket.ListTicketTersedia();

        System.out.print("Pilih tiket: ");

        // Scanner pilihan
        Scanner inputTiket = new Scanner(System.in);
        int tiketPilihan = inputTiket.nextInt();

        try{
            // Proses pengambilan data
            tiketData beliTiket = new tiketData(tiketPilihan);

            // proses transaksi
            Transaksi transaksi = new Transaksi(beliTiket.getTiketData());
            transaksi.displaySaldo();

            // Penambahan data ke database user

            // Penghapusan data dari database tiket
            if(!transaksi.getIsBokek()){
                beliTiket.updateDatabase();
            }


        } catch (Exception e){
            System.out.println("Mohon pilih angka yang valid");
        }
        // Kembali ke main menu
        Main.yesOrNo();
    }


}
