package com.airline.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Cancel {
    void viewCancel(User userData) throws IOException {
        // Scanner
        System.out.print("Apakah anda yakin ? (y/n) ");
        Scanner scanner = new Scanner(System.in);
        String inputCancel = scanner.nextLine();

        if(inputCancel.equals("y")){
            try{
                // Menghapus tiket di user
                ListUser.hapusIsiTiket(userData.userPilihan, totalRefund(userData));

                // Menambahkan tiket ke database tiket @FAZA

                // Kembali ke main
                Main.yesOrNo();

            }catch(Exception e){
                Main.yesOrNo();
            }
        }
        else{
            Main.yesOrNo();
        }

    }
    // Mengambil informasi harga dari tiket
    int getTicketUserHarga(User userData) throws IOException {
        String dataUser = Files.readAllLines(Paths.get("listUser.txt")).get(userData.userPilihan - 1);
        String[] splitted = dataUser.split("_");
        String tiketDataUser = splitted[2];

        String[] splitTiketUser = tiketDataUser.split(",");
        int hargaTiketUser = Integer.parseInt(splitTiketUser[3]);

        return hargaTiketUser;
    }

    int getSaldoUser(User userData) throws IOException {
        String dataUser = Files.readAllLines(Paths.get("listUser.txt")).get(userData.userPilihan - 1);
        String[] splitted = dataUser.split("_");
        int saldoUser = Integer.parseInt(splitted[1]);

        return saldoUser;
    }

    String totalRefund(User userData) throws IOException {
        return Integer.toString(getTicketUserHarga(userData)+getSaldoUser(userData));
    }
}
