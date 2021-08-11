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
        System.out.println("\nNama\t: " + userData.getnamaUser() +", Saldo anda " + userData.getSaldo());


        System.out.println("\nAIRLINE RESERVATION");
        System.out.println("===================");

        System.out.print("""
                1. Booking pesawat
                2. Cek Tiket Tersedia
                3. Cancel Tiket
                
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
                Main.yesOrNo();
            }
            case "3" -> {
                System.out.println("Cancel Tiket\n");
                Cancel cancel = new Cancel();
                cancel.viewCancel(userData);

            }
            default -> System.err.println("input tidak valid\nmohon pilih antara 1-4");
        }
    }

    static void yesOrNo() throws IOException {
        System.out.print("Kembali ke main menu? (y/n) ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if(input.equals("y")){
            //Cls();
            mainMenu();

        }else{
            System.out.println("Terimakasih telah menggunakan layanan kami");
        }
    }

    private static void Cls(){
        try {
            new ProcessBuilder("cmd","c","cls").inheritIO().start().waitFor();
        }catch (Exception ex){
            System.err.println("gabisa cls");
        }
    }

}

