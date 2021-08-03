package com.airline.core;

public class bookingPesawat {
    static void viewBookingPesawat(){
        int i = 1;
        for(String list: dummyList()){
            System.out.println(i+". " + list);
        }
    }

    static String[] dummyList(){
        String[] tikets = {"Garuda", "Air Asia", "Batik Air"};

        return tikets;
    }
}
