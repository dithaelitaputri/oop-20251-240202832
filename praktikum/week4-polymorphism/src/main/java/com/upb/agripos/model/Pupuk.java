package com.upb.agripos.model;

public class Pupuk {
    private String jenis;
    private double harga;

    public Pupuk(String jenis, double harga) {
        this.jenis = jenis;
        this.harga = harga;
    }

    public void tampilInfo() {
        System.out.println("Jenis Pupuk: " + jenis);
        System.out.println("Harga: " + harga);
    }
}
