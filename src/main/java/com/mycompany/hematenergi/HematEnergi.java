/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hematenergi;

/**
 *
 * @author Hofifah
 */

import java.util.Scanner;

public class HematEnergi {
    
    // Patokan: daya sama atau lebih dari ini dianggap peralatan daya besar
    private static final int BATAS_DAYA_BESAR = 500;

    // Membaca teks, diulang sampai pengguna tidak mengosongkan input
    private static String bacaTeks(Scanner input, String pesan) {
        String teks = "";
        while (teks.isEmpty()) {
            System.out.print(pesan);
            teks = input.nextLine().trim();
            if (teks.isEmpty()) {
                System.out.println("Input tidak boleh kosong.");
            }
        }
        return teks;
    }

    // Membaca angka lebih dari 0, diulang sampai input benar
    private static double bacaAngka(Scanner input, String pesan) {
        while (true) {
            System.out.print(pesan);
            String teks = input.nextLine().trim().replace(',', '.');
            try {
                double angka = Double.parseDouble(teks);
                if (angka > 0) {
                    return angka;
                }
                System.out.println("Angka harus lebih besar dari 0.");
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Contoh: 1500 atau 2.5");
            }
        }
    }

    // Proses menambah satu data pemakaian
    private static void tambahData(Scanner input, CatatanListrik catatan) {
        System.out.println("\n--- Tambah Data Pemakaian ---");
        String nama = bacaTeks(input, "Nama peralatan          : ");
        int watt = (int) bacaAngka(input, "Daya peralatan (Watt)   : ");
        double kwh = bacaAngka(input, "Pemakaian listrik (kWh) : ");

        // Program yang menentukan jenisnya berdasarkan daya
        Peralatan peralatan;
        if (watt >= BATAS_DAYA_BESAR) {
            peralatan = new PeralatanDayaBesar(nama, kwh, watt);
        } else {
            peralatan = new Peralatan(nama, kwh);
        }

        catatan.tambahPeralatan(peralatan);

        System.out.println("\n===== HASIL PENCATATAN =====");
        peralatan.tampilkanInfo(catatan.getPengguna().getTarifPerKwh());
        System.out.println("============================");
    }
    
    // Proses menghapus satu data pemakaian
    private static void hapusData(Scanner input, CatatanListrik catatan) {
        System.out.println("\n--- Hapus Data Pemakaian ---");

        if (catatan.getJumlahData() == 0) {
            System.out.println("Belum ada data yang bisa dihapus.");
            return;
        }

        catatan.tampilkanRiwayat();
        int nomor = (int) bacaAngka(input, "\nMasukkan nomor data yang dihapus: ");

        if (catatan.hapusPeralatan(nomor)) {
            System.out.println("Data ke-" + nomor + " berhasil dihapus.");
        } else {
            System.out.println("Nomor data tidak ditemukan.");
        }
    }

        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== HematEnergi ===");
        System.out.println("Pencatatan dan Estimasi Listrik Rumah Tangga\n");

        String namaPengguna = bacaTeks(input, "Masukkan nama pengguna       : ");
        double tarif = bacaAngka(input, "Masukkan tarif per kWh (Rp) : ");

        Pengguna pengguna = new Pengguna(namaPengguna, tarif);
        CatatanListrik catatan = new CatatanListrik(pengguna);

        String pilihan;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tambah data pemakaian");
            System.out.println("2. Lihat riwayat pencatatan");
            System.out.println("3. Hapus data pemakaian");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pilihan = input.nextLine().trim();

            switch (pilihan) {
                case "1":
                    tambahData(input, catatan);
                    break;
                case "2":
                    catatan.tampilkanRiwayat();
                    break;
                case "3":
                    hapusData(input, catatan);
                    break;
                case "4":
                    System.out.println("\nTerima kasih, " + pengguna.getNama() + ". Sampai jumpa!");
                    break;
                default:
                    System.out.println("Menu tidak tersedia. Pilih 1, 2, 3, atau 4.");
            }
        } while (!pilihan.equals("4"));

        input.close();
    }
}
