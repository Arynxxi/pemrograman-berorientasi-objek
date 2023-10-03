import java.util.Scanner;

public class DataKaryawan {

    public static void main(String[] args) {

        String nama, alamat;
        int usia, gaji;

        Scanner keyboard = new Scanner (System.in);

        System.out.println("### Pendataan Karyawan PT. Petani Kode ###");
        System.out.print("Nama Karyawan: ");
        nama = keyboard.nextLine();

        System.out.print("Alamat: ");
        alamat = keyboard.nextLine();

        System.out.print("Usia: ");
        usia = keyboard.nextInt();

        System.out.print("Gaji: ");
        gaji = keyboard.nextInt();

        System.out.println("-----------------------------------------");
        System.out.println("Nama Karyawan: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Usia: " + usia);
        System.out.println("Gaji: " + gaji);

    }

}
