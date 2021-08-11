package com.airline.core;

import java.io.*;
import java.util.Scanner;

public class bookingPesawat {
    void viewBookingPesawat(User userData) throws IOException {

        if(!userData.getUserTicket()[2].equals("kosong")){
            System.out.println("Anda Sudah punya tiket, jangan maruk");
            Main.yesOrNo();
        }else{
            // Memunculkan list tiket tersedia
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
                transaksi.hitungSaldo(userData);
                // Penambahan tiket ke database user
                ListUser.isiTiket(tiketPilihan, userData.userPilihan, transaksi);

                // Penghapusan data dari database tiket
                beliTiket.updateDatabase();

                // list user sementara
                ListUser.viewListUser();

            } catch (Exception e){
                System.out.println("Mohon pilih angka yang valid");
            }
            // Kembali ke main menu
            Main.yesOrNo();
        }




    }


}
