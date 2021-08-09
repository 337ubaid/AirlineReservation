package com.airline.core;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static User userData = new User();
    public static void main(String[] args) throws IOException {
        userData.viewListUser();
        mainMenu();
    }

    static void mainMenu() throws IOException {
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

        switch (pilih) {
            case "1" -> {
                System.out.println("\nBooking pesawat");
                bookingPesawat book = new bookingPesawat();
                book.viewBookingPesawat(userData);
            }
            case "2" -> {
                System.out.println("Tiket Tersedia");
                ListTicket listTicket = new ListTicket();
                listTicket.ListTicketTersedia();
            }
            case "3" -> {
                System.out.println("Cancel Tiket");
                Cancel cancel = new Cancel();
                cancel.viewCancel(userData);

            }
            case "4" -> System.out.println("Ganti Jadwal");
            default -> System.err.println("mohon pilih antara 1-4");
        }
    }

    static void yesOrNo() throws IOException {
        System.out.print("Kembali ke main menu? (y/n) ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if(input.equals("y")){
            mainMenu();
        }else{
            System.out.println("Terimakasih telah menggunakan layanan kami");
        }
    }

}

