package main.java.com.upb.agripos.util;

import main.java.com.upb.agripos.model.Produk;
import main.java.com.upb.agripos.util.CreditBy;

public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("TOB-001", "Totebag ", 60000, 50);
        Produk p2 = new Produk("KMJ-002", "Kemeja", 80000, 30);
        Produk p3 = new Produk("FLS-003", "Flat Shoes", 40000, 15);

        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());
        
        System.out.println("perubahan stok") ;
        p1.tambahStok(10);
        p2.kurangiStok(5);

        System.out.println(p1.getNama() + " Sisa Stok: " + p1.getStok()) ;
        System.out.println(p2.getHarga() + " Sisa Stok: " + p2.getStok()) ;

        // Tampilkan identitas mahasiswa
        CreditBy.print("240202864", "Hanifah");
    }
}