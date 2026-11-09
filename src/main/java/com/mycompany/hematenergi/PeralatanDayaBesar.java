/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hematenergi;

/**
 *
 * @author Hofifah
 */
// "extends" artinya class ini mewarisi Peralatan
public class PeralatanDayaBesar extends Peralatan {
    private int dayaWatt; // atribut tambahan khusus subclass

    public PeralatanDayaBesar(String namaPeralatan, double pemakaianKwh, int dayaWatt) {
        super(namaPeralatan, pemakaianKwh); // memanggil constructor superclass
        this.dayaWatt = dayaWatt;
    }

    public int getDayaWatt() {
        return dayaWatt;
    }

    public void setDayaWatt(int dayaWatt) {
        if (dayaWatt > 0) {
            this.dayaWatt = dayaWatt;
        }
    }

    // Override: mengganti isi method milik superclass
    @Override
    public String getKategori() {
        return "Peralatan Daya Besar";
    }

    // Override: memakai tampilan superclass, lalu menambah info khusus
    @Override
    public void tampilkanInfo(double tarifPerKwh) {
        super.tampilkanInfo(tarifPerKwh);
        System.out.println("Daya      : " + dayaWatt + " Watt");
        System.out.println("Catatan   : Peralatan ini tergolong boros, gunakan seperlunya.");
    }
}


