import java.util.Scanner;

public class Hadiah {

    public static void main(String[] args) {

        int belanja = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Total Belanjaan: Rp. ");
        belanja = scanner.nextInt();

        if ( belanja > 100000 ) {
            System.out.println("Selamat anda mendapatkan hadiah");
        } else {
            System.out.println("Terima kasih...");
        }

    }

}
