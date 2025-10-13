package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.Produk;
import main.java.com.upb.agripos.util.CreditBy;

public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("KMJ-001", "Kemeja", 95000, 100);
        Produk p2 = new Produk("DSH-002", "Dasi Hitam", 15000, 40);
        Produk p3 = new Produk("TPP-003", "Topi Pramuka", 20000, 15);

        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());
        
        // Transaksi penambahan stok
        p1.tambahStok(5); // stok datang dari gudang
      
        // Transaksi pengurangan stok
         p2.kurangiStok(20); // produk dibeli pelanggan

        // Tampilkan identitas mahasiswa
        CreditBy.print("240202832", "Ditha Elita Putri");
        
    }
}