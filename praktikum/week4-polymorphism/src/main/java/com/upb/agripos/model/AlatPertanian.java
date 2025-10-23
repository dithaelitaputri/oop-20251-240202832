package com.upb.agripos.model;

public class AlatPertanian {
    private String nama;
    private double harga;

    public AlatPertanian(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public void tampilInfo() {
        System.out.println("Nama Alat: " + nama);
        System.out.println("Harga: " + harga);
    }
}
