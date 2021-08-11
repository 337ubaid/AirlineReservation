package com.airline.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class User {
    String dataUser;
    String nama;
    int userPilihan;
    int saldo;



    // Memunculkan view list user
    void viewListUser() throws IOException {
        ListUser.viewListUser();
        System.out.print("Siapakah anda? ");
        // Pilihan user yang mana
        Scanner scanner = new Scanner(System.in);
        this.userPilihan = scanner.nextInt();
    }

    // Mengambil data user
    // Mengambil data tiket pada baris pilihan user
    String dataUser() throws IOException {
        this.dataUser = Files.readAllLines(Paths.get("listUser.txt")).get(this.userPilihan - 1);
        return this.dataUser;
    }
    public String[] getUserTicket() throws IOException {
        String[] ticketUser = dataUser().split("_");

        return ticketUser;
    }

    // Mengambil info saldo user
    public int getSaldo() throws IOException {
        this.saldo = Integer.parseInt(getUserTicket()[1]);

        return this.saldo;
    }


    //buat ambil nama user
    public String getnamaUser() throws IOException {
        this.nama = String.format(getUserTicket()[0]);

        return this.nama;
    }


    // jika punya tiket, ngga bisa beli lagi

    // Nambah info tiket yang barusan di beli ke database (ngereplace elemen ke 3)




}