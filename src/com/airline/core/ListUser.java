package com.airline.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ListUser {
    public static void viewListUser() throws IOException {

        // Nama, Saldo, Tiket

        // Membuat dan membaca database list user
        FileReader fileInput = new FileReader("listUser.txt");
        BufferedReader bufferedInput = new BufferedReader(fileInput);


        String data = bufferedInput.readLine();
        int nomorData = 0;

        System.out.println("\n| No " + "|\tNama         " + "|\tSaldo      " + "|\tTiket  " );
        System.out.println("---------------------------------------------------------------------------------");

        while (data != null) {
            nomorData++;
            StringTokenizer st = new StringTokenizer(data, "_");

            System.out.printf("| %2d ", nomorData);
            System.out.printf("|\t%-12s ", st.nextToken());
            int harga = Integer.parseInt(st.nextToken());
            System.out.printf("|\t%,10d ", harga);
            System.out.printf("|\t%-18s ", st.nextToken());
            System.out.println();

            data = bufferedInput.readLine();
        }
        System.out.println("---------------------------------------------------------------------------------");

        fileInput.close();
        bufferedInput.close();
    }

    public static void isiTiket(int barisPilihanUser, String namaUser) throws IOException{
        // Membaca database listTicket
        FileReader fileTicket = new FileReader("listTicket.txt");
        BufferedReader bufferedTicket = new BufferedReader(fileTicket);

        // Membaca database listUser
        File listUser = new File("listUser.txt");
        FileReader fileUser = new FileReader(listUser);
        BufferedReader bufferedUser = new BufferedReader(fileUser);

        // Mengambil data tiket pada baris pilihan user
        String data = bufferedTicket.readLine();
        String tiketPilihan = "kosong";

        int numBaris = 0;

        while (data != null){
            numBaris++;
            if (numBaris == barisPilihanUser){
                tiketPilihan = data;
                break;
            }
            data = bufferedTicket.readLine();
        }

        System.out.println(tiketPilihan);
    }
}
