package com.airline.core;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("AIRLINE RESERVATION");
        System.out.println("===================");

        System.out.print("1. Booking pesawat\n" +
                "2. Cek Tiket Tersedia\n" +
                "3. Cancel Tiket\n" +
                "4. Ganti Jadwal\n" +
                "\n" +
                "pilih menu: ");

        Scanner inputmenu = new Scanner(System.in);
        int pilih = inputmenu.nextInt();
    }
}
