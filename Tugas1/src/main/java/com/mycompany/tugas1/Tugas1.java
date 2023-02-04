/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tugas1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Akihira 17
 */

// interface
interface Calculate {
    public double hitung(double value, int N);
}

// abstract class
abstract class Declaration {
    String nama, nik;
    double modalAwal = 20000000;

    //abstract method
    public abstract void list();
    public abstract void data(String nama, String nik);

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }
}




public class Tugas1 {
    static double[] harga = {0, 45000, 50000, 40000, 38000, 22000};
    static DecimalFormat formatter = new DecimalFormat("%.2f");
    
    // barang masuk
    static class Add extends Declaration implements Calculate {
        @Override
        public double hitung(double value, int N) {
            return value * N;
        }

        @Override
        public void list() {
            System.out.println("\n\t\t*** Pendataan Barang Masuk PT. Garuda Abadi Group ***");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("||  Jenis Barang   ||   Nama Barang    ||   Jumlah   ||   Harga    ||");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("||  1. Buku        ||   Buku Tulis     ||   1 Pak    || Rp. 45.000 ||");
            System.out.println("||  2. Buku        ||   Buku Gambar    ||   1 Pak    || Rp. 50.000 ||");
            System.out.println("||  3. Kertas      ||   Kertas A4      ||   1 Rim    || Rp. 40.000 ||");
            System.out.println("||  4. Bulpen      ||   Bulpen Biru    ||   1 Pak    || Rp. 38.000 ||");
            System.out.println("||  5. Pensil      ||   Pensil Raut    ||   1 Pak    || Rp. 22.000 ||");
        }

        @Override
        public void data(String nama, String nik) {
            setNama(nama);
            setNik(nik);
        }
    }

    // barang keluar
    static class Out extends Declaration implements Calculate {
        @Override
        public double hitung(double value, int N) {
            return value * N;
        }

        @Override
        public void list() {
            System.out.println("\n*** Pendataan Barang Keluar PT. Garuda Abadi Group ***");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("||  Jenis Barang   ||   Nama Barang    ||   Jumlah   ||   Harga    ||");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("||  1. Buku        ||   Buku Tulis     ||   1 Pak    || Rp. 45.000 ||");
            System.out.println("||  2. Buku        ||   Buku Gambar    ||   1 Pak    || Rp. 50.000 ||");
            System.out.println("||  3. Kertas      ||   Kertas A4      ||   1 Rim    || Rp. 40.000 ||");
            System.out.println("||  4. Bulpen      ||   Bulpen Biru    ||   1 Pak    || Rp. 38.000 ||");
            System.out.println("||  5. Pensil      ||   Pensil Raut    ||   1 Pak    || Rp. 22.000 ||");
        }

        @Override
        public void data(String nama, String nik) {
            setNama(nama);
            setNik(nik);
        }
    }

    public static class Login {
        private String ID = "admin123";
        public boolean Login(String id) {
            return (id.equals(ID));
        }
    }
    
    public static void main(String[] args) {
        System.out.println("\t\t--- Distributor PT. Garuda Abadi Group ---");
        System.out.println("\t\t==========================================");
        System.out.println("Silahkan Masukkan ID Anda");
        System.out.println("=========================");
        System.out.print("ID : ");
        
        Scanner input = new Scanner(System.in);
        String id = input.nextLine();
        
        // Autentikasi ID Admin
        Login person = new Login();
        if (person.Login(id)) {
            System.out.println("\nPilih Chek Data Barang : ");
            System.out.println("1. Barang Masuk");
            System.out.println("2. Barang Keluar\n");
            
            System.out.print("Masukkan Pilihan Data : ");
            int choice = input.nextInt();
            System.out.println("======================\n");
            
            System.out.println("Silahkan Masukkan Data Anda");
            System.out.println("===========================");
            System.out.print("Nama Admin : ");
            String nama = input.nextLine();

            input.nextLine();
            
            System.out.print("\nNIK Admin : ");
            String nik = input.nextLine();
            if (choice == 1) {
                Add addUser = new Add();
                addUser.data(nama, nik);
                
                addUser.list();
                int i = 2;
                while (i-- > 0) {
                    System.out.print("Pilihan Anda : ");
                    choice = input.nextInt();
                    
                    System.out.print("Banyaknya Barang Yang Masuk : ");
                    int banyakBarang = input.nextInt();
                    
                    System.out.println("Data Tersimpan");
                    double hitung = addUser.hitung(harga[choice], banyakBarang);
                    addUser.modalAwal += hitung;
                    System.out.println("Harga sebesar : Rp" + String.format("%,.2f", hitung));
                    System.out.println(" --------------------------------------------------------------------");
                }
                System.out.println("Sisa Kas dari Total Pengeluaran : Rp" + String.format("%,.2f", addUser.modalAwal));
            } else {
                Out outUser = new Out();
                
                outUser.list();
                int i = 2;
                while (i-- > 0) {
                    System.out.print("Pilihan Anda : ");
                    choice = input.nextInt();
                    
                    System.out.print("Banyaknya Barang Yang Keluar : ");
                    int banyakBarang = input.nextInt();
                    
                    System.out.println("Data Tersimpan");
                    double hitung = outUser.hitung(harga[choice], banyakBarang);
                    outUser.modalAwal -= hitung;
                    System.out.println("Harga sebesar : Rp" + String.format("%,.2f", hitung));
                    System.out.println(" ----------------------------------------------------------------");
                }
                System.out.println("Sisa Kas dari Total Pengeluaran : Rp" + String.format("%,.2f", outUser));
            }
        } else {
            System.out.println("ID Anda salah -> " + id + "\n");
        }
        
        System.out.println("Administrasi Persediaan Barang PT. Garuda Abadi Group");
        System.out.println("Chek, Data dan Antar, Ketelitian Anda dalam Administrasi di Utamakan (*_*)");
    }
}
