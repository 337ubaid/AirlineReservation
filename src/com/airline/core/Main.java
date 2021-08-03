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
        String pilih = inputmenu.next();

        switch (pilih){
            case "1":
                System.out.println("Booking pesawat");
                break;
            case "2":
                System.out.println("Tiket Tersedia");
                break;
            case "3":
                System.out.println("Cancel Tiket");
                break;
            case "4":
                System.out.println("Ganti Jadwal");
                break;
            default:
                System.err.println("mohon pilih antara 1-4");

        }
    }
}
