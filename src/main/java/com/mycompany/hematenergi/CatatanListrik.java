/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hematenergi;

/**
 *
 * @author Hofifah
 */
import java.util.ArrayList;

public class CatatanListrik {
    private Pengguna pengguna;
    private ArrayList<Peralatan> daftarPeralatan; // riwayat pencatatan

    public CatatanListrik(Pengguna pengguna) {
        this.pengguna = pengguna;
        this.daftarPeralatan = new ArrayList<>();
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public int getJumlahData() {
        return daftarPeralatan.size();
    }

    // Bisa menerima Peralatan maupun PeralatanDayaBesar
    public void tambahPeralatan(Peralatan peralatan) {
        daftarPeralatan.add(peralatan);
    }
    
    // Menghapus data berdasarkan nomor yang tampil di riwayat (mulai dari 1)
    public boolean hapusPeralatan(int nomor) {
        if (nomor < 1 || nomor > daftarPeralatan.size()) {
            return false; // nomor tidak ada
        }
        daftarPeralatan.remove(nomor - 1); // list dimulai dari 0, jadi dikurangi 1
        return true;
    }

    public double hitungTotalKwh() {
        double total = 0;
        for (Peralatan p : daftarPeralatan) {
            total += p.getPemakaianKwh();
        }
        return total;
    }

    public double hitungTotalBiaya() {
        return hitungTotalKwh() * pengguna.getTarifPerKwh();
    }

    public void tampilkanRiwayat() {
        System.out.println("\n===== RIWAYAT PENCATATAN =====");
        System.out.println("Pengguna : " + pengguna.getNama());
        System.out.println("Tarif    : " + Peralatan.formatRupiah(pengguna.getTarifPerKwh()) + " per kWh");

        if (daftarPeralatan.isEmpty()) {
            System.out.println("\nBelum ada data yang dicatat.");
            return;
        }

        int nomor = 1;
        for (Peralatan p : daftarPeralatan) {
            System.out.println("\nData ke-" + nomor);
            p.tampilkanInfo(pengguna.getTarifPerKwh());
            nomor++;
        }

        System.out.println("\n------------------------------");
        System.out.println("Total pemakaian : " + hitungTotalKwh() + " kWh");
        System.out.println("Total estimasi  : " + Peralatan.formatRupiah(hitungTotalBiaya()));
    }
}