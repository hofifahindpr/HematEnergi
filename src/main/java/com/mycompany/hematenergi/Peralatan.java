/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hematenergi;

/**
 *
 * @author Hofifah
 */
import java.util.Locale;

public class Peralatan {
    // Encapsulation: atribut dibuat private
    private String namaPeralatan;
    private double pemakaianKwh;

    // Constructor: dipanggil saat membuat object dengan "new"
    public Peralatan(String namaPeralatan, double pemakaianKwh) {
        this.namaPeralatan = namaPeralatan;
        this.pemakaianKwh = pemakaianKwh;
    }

    // Getter dan setter
    public String getNamaPeralatan() {
        return namaPeralatan;
    }

    public void setNamaPeralatan(String namaPeralatan) {
        this.namaPeralatan = namaPeralatan;
    }

    public double getPemakaianKwh() {
        return pemakaianKwh;
    }

    public void setPemakaianKwh(double pemakaianKwh) {
        if (pemakaianKwh > 0) {
            this.pemakaianKwh = pemakaianKwh;
        }
    }

    // Method ini akan di-override oleh subclass
    public String getKategori() {
        return "Peralatan Biasa";
    }

    // Rumus: estimasi biaya = pemakaian (kWh) x tarif per kWh
    public double hitungBiaya(double tarifPerKwh) {
        return pemakaianKwh * tarifPerKwh;
    }

    // Menampilkan hasil pencatatan satu peralatan
    public void tampilkanInfo(double tarifPerKwh) {
        System.out.println("Peralatan : " + namaPeralatan);
        System.out.println("Kategori  : " + getKategori());
        System.out.println("Pemakaian : " + pemakaianKwh + " kWh");
        System.out.println("Biaya     : " + formatRupiah(hitungBiaya(tarifPerKwh)));
    }

    // Method bantu untuk menulis angka dalam format Rupiah, contoh: Rp225.000
    public static String formatRupiah(double angka) {
        return String.format(Locale.forLanguageTag("id-ID"), "Rp%,.0f", angka);
    }
}
