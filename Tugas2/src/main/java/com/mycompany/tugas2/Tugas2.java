package com.mycompany.tugas2;

import java.util.Scanner;

public class Tugas2 {
    
    // Parent Class 
    // Dengan tiga Overloading Method
    public static class Person {
        String nama, nik, alamat, pekerjaan, alamatKantor, status, namaPasangan, noHp;
        int anak;
        public void setPerson(String nama, String nik, String alamat, String noHp) {
            this.nama = nama;
            this.nik = nik;
            this.alamat = alamat;
            this.noHp = noHp;
        }
        public void setPerson(String pekerjaan, String alamatKantor) {
            this.pekerjaan = pekerjaan;
            this.alamatKantor = alamatKantor;
        }
        public void setPerson(String status, String namaPasangan, int anak) {
            this.status = status;
            this.namaPasangan = namaPasangan;
            this.anak = anak;
        }
    }
    
    // Child class, inherit atau mewarisi Class Person
    // satu Overriding Method dan satu Method jumlah 
    public static class Iuran extends Person {
        long iuranSampah, iuranKeamanan, sumbangan, total = 0;
        public void setPerson(long iuranSampah, long iuranKeamanan, long sumbangan) {
            this.iuranSampah = iuranSampah;
            this.iuranKeamanan = iuranKeamanan;
            this.sumbangan = sumbangan;
        }
        public long jumlah() {
            return this.iuranKeamanan + this.iuranSampah + this.sumbangan;
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("====================================");
        System.out.println("Pendataan dan Pembayaran Iuran Warga");
        System.out.println("====================================");
        
        // pilih
        System.out.println("1. Input Data Warga");
        System.out.println("2. Input Iuran Warga");
        
        System.out.print("PILIHAN MENU : ");
        int choice = input.nextInt();
        
        // instansiasi Object
        Iuran warga = new Iuran();
        if (choice == 1) {
            // Inputkan Data Warga
            // Nama, NIK, Alamat, dan NoHP
            System.out.println("----------------------------------------------");
            System.out.println("*** Data Warga ***");
            System.out.println("Masukkan Nama");
            input.nextLine();
            String nama = input.nextLine();
            System.out.println("Masukkan NIK");
            String nik = input.nextLine();
            System.out.println("Masukkan Alamat");
            String alamat = input.nextLine();
            System.out.print("Masukkan No. Tlp \n+62 ");
            String noHp = input.nextLine();
            System.out.println("----------------------------------------------");
            // set Atribut ke Object yang sudah dibuat
            warga.setPerson(nama, nik, alamat, noHp);
            

            // Inputkan Data Pekerjaan
            // Pekerjaan, dan Alamat Kantor
            System.out.println("----------------------------------------------");
            System.out.println("*** Data Pekerjaan ***");
            System.out.println("Masukkan Pekerjaan");
            String pekerjaan = input.nextLine();
            System.out.println("Masukkan Alamat Kantor");
            String alamatKantor = input.nextLine();
            System.out.println("----------------------------------------------");
            // set Atribut ke Object yang sudah dibuat
            warga.setPerson(pekerjaan, alamatKantor);

            
            // Inputkan Data Status
            // Status, NamaPasangan, JumlahAnak
            System.out.println("----------------------------------------------");
            System.out.println("*** Data Status ***");
            System.out.println("Masukkan Status");
            String status = input.nextLine();
            System.out.println("Masukkan Nama Suami/Istri");
            String namaPasangan = input.nextLine();
            System.out.println("Masukkan Jumlah Anak");
            int anak = input.nextInt();
            System.out.println("----------------------------------------------");
            // set Atribut ke Object yang sudah dibuat
            warga.setPerson(status, namaPasangan, anak);
            
        }   
        // Akan terus melakukan looping yang diawali dengan pertanyaan "Lanjut Bayar Iuran?"
        // jika menjawab "ya" maka looping ini akan terus berlanjut 
        // jika menjawab selain "ya" maka looping akan mengeluarkan output pada baris kode "else {}" setelah itu program akan berhenti
        while (true) {
            System.out.println("Lanjut Bayar Iuran ?");
            input.nextLine();
            String pilih = input.nextLine();
            if (pilih.equals("ya")) {
                System.out.println("--------------------------------------------");
                System.out.println("*** Data Iuran Pokok ***");
                System.out.println("NIK =>" + warga.nik);
                System.out.println("Masukkan Iuran Sampah");
                int iuranSampah = input.nextInt();
                System.out.println("Masukkan Iuran Keamanan");
                int iuranKeamanan = input.nextInt();
                
                
                System.out.println("*** Data Iuran Sekunder ***");
                System.out.println("Masukkan Sumbangan");
                int sumbangan = input.nextInt();
                warga.setPerson(iuranSampah, iuranKeamanan, sumbangan);
                warga.total += warga.jumlah();
            } else {
                System.out.println("|| NIK                          || " + warga.nik);
                System.out.println("|| Total Pembayaran Iuran Warga  || Rp. " + warga.total);
                System.out.println("Terimakasih " + warga.nama + " Iuran Anda sudah dibayarkan");
                break;
            }
        }
    }
}
