/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hematenergi;

/**
 *
 * @author Hofifah
 */
public class Pengguna {
    private String nama;
    private double tarifPerKwh;

    public Pengguna(String nama, double tarifPerKwh) {
        this.nama = nama;
        this.tarifPerKwh = tarifPerKwh;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getTarifPerKwh() {
        return tarifPerKwh;
    }

    public void setTarifPerKwh(double tarifPerKwh) {
        if (tarifPerKwh > 0) {
            this.tarifPerKwh = tarifPerKwh;
        }
    }
}