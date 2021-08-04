package com.airline.core;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("AIRLINE RESERVATION");
        System.out.println("===================");

        System.out.print("""
                1. Booking pesawat
                2. Cek Tiket Tersedia
                3. Cancel Tiket
                4. Ganti Jadwal

                pilih menu:\s""");

        Scanner inputmenu = new Scanner(System.in);
        String pilih = inputmenu.next();

        switch (pilih){
            case "1":
                System.out.println("Booking pesawat\n");
                bookingPesawat book = new bookingPesawat();
                book.viewBookingPesawat();
                break;
            case "2":
                System.out.println("Tiket Tersedia");
                ListTicket listTicket = new ListTicket();
                listTicket.Tersedia();

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

