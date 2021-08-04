package com.airline.core;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ListTicket {

    public static void ListTicketTersedia() throws IOException {

        // Kota tujuan, maskapai, Kelas penerbangan, harga, tanggal pergi

        // kelas penerbangan : economy, premium economy, business, first class

        // Membuat dan membaca database list tiket
        File listTicket = new File("listTicket.txt");
        FileReader fileInput = new FileReader(listTicket);
        BufferedReader bufferedInput = new BufferedReader(fileInput);


        String data = bufferedInput.readLine();
        int nomorData = 0;

        System.out.println("\n| No " + "|\tTujuan          " + "|\tMaskapai   " + "|\tKelas Penerbangan  " + "|\tHarga    " + "|\tTanggal");
        System.out.println("----------------------------------------------------------------------------------------");

        while (data != null){
            nomorData++;
            StringTokenizer st = new StringTokenizer(data,",");

            System.out.printf("| %2d ",nomorData);
            System.out.printf("|\t%-15s ", st.nextToken());
            System.out.printf("|\t%-10s ", st.nextToken());
            System.out.printf("|\t%-18s ", st.nextToken());
            System.out.printf("|\t%8s ", st.nextToken());
            System.out.printf("|\t%-9s ", st.nextToken());
            System.out.println();

            data = bufferedInput.readLine();
        }
        System.out.println("----------------------------------------------------------------------------------------");

        fileInput.close();
        bufferedInput.close();
    }

    public static void HapusListTicket (int pilihanUser) throws IOException{

        // Membaca database (listTicket.txt)
        File listTicket = new File("listTicket.txt");
        FileReader fileInput = new FileReader(listTicket);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        // Membuat temporaray database (tempatLT.txt)
        File tempLT = new File("tempLT.txt");
        FileWriter fileOutput = new FileWriter(tempLT);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        String data = bufferedInput.readLine();
        int numBaris = 0;

        // Membaca data tiap baris
        while (data != null) {
            numBaris++;

            // Skip data yang dihapus
            if (numBaris != pilihanUser){
                bufferedOutput.write(data);
                bufferedOutput.newLine();
            }
            data = bufferedInput.readLine();
        }

        bufferedOutput.flush();

        fileInput.close();
        bufferedInput.close();
        fileOutput.close();
        bufferedOutput.close();

        System.gc();

        listTicket.delete();

        tempLT.renameTo(listTicket);

//        ListTicketTersedia(); // Uncommand untuk melihat perubahan
    }

    public static void TambahListTicket (String data) throws IOException{
        // Membaca database (listTicket.txt)
        FileReader fileInput = new FileReader("listTicket.txt");
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        // Membuat temporaray database (tempatLT.txt)
        FileWriter fileOutput = new FileWriter("listTicket.txt",true);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        // Menambahkan data di database
        bufferedOutput.write(data);
        bufferedOutput.newLine();
        bufferedOutput.flush();

        fileInput.close();
        fileOutput.close();
        bufferedInput.close();
        bufferedOutput.close();
    }
}
