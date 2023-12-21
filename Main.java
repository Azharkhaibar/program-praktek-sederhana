import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String CATATAN_FILE = "catatan.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== PROGRAM AZHAR ===");
            System.out.println("1. Membuat Segitiga Siku-siku");
            System.out.println("2. Membuat Lingkaran");
            System.out.println("3. Membuat Layang-layang dengan Bintang");
            System.out.println("4. Catatan Hari-hari");
            System.out.println("5. Menghitung Deret Ganjil atau Genap");
            System.out.println("6. Pesan Tiket Azhar");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    membuatSegitigaSiku();
                    break;
                case 2:
                    membuatLingkaran();
                    break;
                case 3:
                    membuatLayangLayang();
                    break;
                case 4:
                    menuCatatan(scanner);
                    break;
                case 5:
                    hitungDeretGanjilGenap();
                    break;
                case 6:
                    pesanTiketAzhar();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        } while (pilihan != 0);

        scanner.close();
    }

    private static void membuatSegitigaSiku() {
        
        System.out.println("Fitur belum ada");
    }

    private static void membuatLingkaran() {
        
        System.out.println("Fitur belum ada");
    }

    private static void membuatLayangLayang() {
        
        int tinggi = 5;
        for (int i = 0; i < tinggi; i++) {
            for (int j = 0; j < tinggi - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i * 2; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void menuCatatan(Scanner scanner) {
        int submenuCatatan;

        do {
            System.out.println("\n=== Menu Catatan ===");
            System.out.println("1. Tambah Catatan");
            System.out.println("2. Tampilkan Catatan");
            System.out.println("3. Simpan Catatan");
            System.out.println("0. Kembali");
            System.out.print("Masukkan pilihan Anda: ");
            submenuCatatan = scanner.nextInt();

            switch (submenuCatatan) {
                case 1:
                    tambahCatatan(scanner);
                    break;
                case 2:
                    tampilkanCatatan();
                    break;
                case 3:
                    simpanCatatan();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (submenuCatatan != 0);
    }

    private static void tambahCatatan(Scanner scanner) {
        System.out.print("Masukkan catatan baru: ");
        String catatanBaru = scanner.nextLine(); // Membaca newline yang belum terbaca sebelumnya
        catatanBaru = scanner.nextLine();
        try {
            FileWriter writer = new FileWriter(CATATAN_FILE, true);
            writer.write(catatanBaru + "\n");
            writer.close();
            System.out.println("Catatan berhasil ditambahkan!");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menambah catatan.");
        }
    }

    private static void tampilkanCatatan() {
        try {
            File file = new File(CATATAN_FILE);
            Scanner fileScanner = new Scanner(file);

            System.out.println("\n=== Catatan ===");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }

            fileScanner.close();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca catatan.");
        }
    }

    private static void simpanCatatan() {
        System.out.println("Catatan berhasil disimpan!");
    }

    private static void hitungDeretGanjilGenap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan batas deret: ");
        int batas = scanner.nextInt();

        System.out.println("Pilih jenis deret (1. Ganjil / 2. Genap): ");
        int jenisDeret = scanner.nextInt();

        int hasil = 0;

        for (int i = 1; i <= batas; i++) {
            if (jenisDeret == 1 && i % 2 != 0) {
                hasil += i;
            } else if (jenisDeret == 2 && i % 2 == 0) {
                hasil += i;
            }
        }

        System.out.println("Hasil penjumlahan deret: " + hasil);
    }

    private static void pesanTiketAzhar() {
        System.out.println("Selamat datang di Konser Azhar!");
        System.out.println("Tiket dapat dibeli melalui website resmi.");
        System.out.println("Jangan lewatkan kesempatan untuk menyaksikan konser spektakuler!");
    }
}
