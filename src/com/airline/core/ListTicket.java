package com.airline.core;

import java.io.*;
import java.util.StringTokenizer;

public class ListTicket {

    public static void Tersedia() throws IOException {

        // Kota tujuan, maskapai, Kelas penerbangan, harga, tanggal pergi

        // kelas penerbangan : economy, premium economy, business, first class

        // Membuat dan membaca database list tiket
        File file = new File("listTicket.txt");
        FileReader fileInput = new FileReader(file);
        BufferedReader bufferedInput = new BufferedReader(fileInput);


        String data = bufferedInput.readLine();
        int nomorData = 0;

        System.out.println("| No " + "|\tTujuan          " + "|\tMaskapai   " + "|\tKelas Penerbangan  " + "|\tHarga    " + "|\tTanggal");
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
    }
}
