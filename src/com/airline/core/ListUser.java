package com.airline.core;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
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
        System.out.println("-------------------------------------------------------------------------------------");

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
        System.out.println("-------------------------------------------------------------------------------------");

        fileInput.close();
        bufferedInput.close();
    }

    public static void isiTiket(int tiketPilihan, int userPilihan, Transaksi transaksi) throws IOException{
        // Membaca database listUser
        File listUser = new File("listUser.txt");
        FileReader fileUser = new FileReader(listUser);
        BufferedReader bufferedUser = new BufferedReader(fileUser);

        // Mengambil data tiket pada baris pilihan user
        String dataTiket = Files.readAllLines(Paths.get("listTicket.txt")).get(tiketPilihan - 1);

        String dataUser = Files.readAllLines(Paths.get("listUser.txt")).get(userPilihan - 1);

        // Mengisi tiket kosong
        File tempLU = new File("tempLU.txt");
        FileWriter fileTempLU = new FileWriter(tempLU);
        BufferedWriter bufferedTempLU = new BufferedWriter(fileTempLU);

        // Mengisi tiket kosong

        String[] tiketKosong = dataUser.split("_");
        tiketKosong[1] = Integer.toString(transaksi.saldoFinal);
        tiketKosong[2] = dataTiket;

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < tiketKosong.length; i++){
            if (i == tiketKosong.length - 1){
                builder.append(tiketKosong[i]);
            }else {
                builder.append(tiketKosong[i]).append("_");
            }
        }

        String dataTiketFinal = builder.toString();

        // Mengkopi ke fiel tempLU
        int numBarisUser = 0;
        String dataUserSemua = bufferedUser.readLine();

        while (dataUserSemua != null){
            numBarisUser++;
            if (numBarisUser == userPilihan){
                bufferedTempLU.write(dataTiketFinal);
            }else{
                bufferedTempLU.write(dataUserSemua);
            }
            bufferedTempLU.newLine();
            dataUserSemua = bufferedUser.readLine();
        }

        bufferedTempLU.flush();

        fileUser.close();
        bufferedUser.close();
        fileTempLU.close();
        bufferedTempLU.close();

        System.gc();

        listUser.delete();

        tempLU.renameTo(listUser);
    }

    public static void hapusIsiTiket (int userPilihan, String hargaTiket) throws IOException{
        // Membaca database listUser
        File listUser = new File("listUser.txt");
        FileReader fileUser = new FileReader(listUser);
        BufferedReader bufferedUser = new BufferedReader(fileUser);


        String dataUser = Files.readAllLines(Paths.get("listUser.txt")).get(userPilihan - 1);
//        String dataTiket = Files.readAllLines(Paths.get("listTicket.txt")).get(tiketPilihan - 1); // Misal ga butuh, delete ae

        // Menghapus isi tiket menjadi kosong
        File tempLU = new File("tempLU.txt");
        FileWriter fileTempLU = new FileWriter(tempLU);
        BufferedWriter bufferedTempLU = new BufferedWriter(fileTempLU);

        // Mengubah isi tiket

        String[] tiketIsi = dataUser.split("_");
        tiketIsi[1] = hargaTiket;
        tiketIsi[2] = "kosong";

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < tiketIsi.length; i++){
            if (i == tiketIsi.length - 1){
                builder.append(tiketIsi[i]);
            }else {
                builder.append(tiketIsi[i]).append("_");
            }
        }

        String dataTiketFinal = builder.toString();

        // Mengkopi ke fiel tempLU
        int numBarisUser = 0;
        String dataUserSemua = bufferedUser.readLine();

        while (dataUserSemua != null){
            numBarisUser++;
            if (numBarisUser == userPilihan){
                bufferedTempLU.write(dataTiketFinal);
            }else{
                bufferedTempLU.write(dataUserSemua);
            }
            bufferedTempLU.newLine();
            dataUserSemua = bufferedUser.readLine();
        }

        bufferedTempLU.flush();

        fileUser.close();
        bufferedUser.close();
        fileTempLU.close();
        bufferedTempLU.close();

        System.gc();

        listUser.delete();

        tempLU.renameTo(listUser);
    }
}
