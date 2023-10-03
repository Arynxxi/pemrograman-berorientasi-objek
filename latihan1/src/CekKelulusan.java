import java.util.Scanner;

public class CekKelulusan {

    public static void main(String[] args) {

        int nilai;
        String nama;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama: ");
        nama = scanner.nextLine();

        System.out.print("Nilai: ");
        nilai = scanner.nextInt();

        if ( nilai >= 70 ) {
            System.out.println("Selamat " + nama + " anda lulus!");
        } else  {
            System.out.println("Maaf " + nama + "anda gagal");
        }

    }

}
