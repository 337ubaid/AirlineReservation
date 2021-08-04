package com.airline.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class tiketData {
    int pilihan;
    String tiket;

    tiketData(int pilihan) throws FileNotFoundException {
        this.pilihan = pilihan;
    }

    String getTiketData() throws IOException {
        this.tiket = Files.readAllLines(Paths.get("listTicket.txt")).get(pilihan - 1);
        return this.tiket;
    }

    // Menghapus line database yang dipilih agar terupdate
    void updateDatabase() {

    }

    void displayList() {

    }

}
