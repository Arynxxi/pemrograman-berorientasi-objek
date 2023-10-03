import java.util.Scanner;

public class InputClassScanner {

    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);
        String nama[] = new String[5];

        for (int i = 0; i < nama.length; i++) {
            System.out.print("Masukkan Nama = ");
            nama[i] = input.next();
        }

        System.out.println("Nama-nama yang diinput yaitu");

        for (int i  = 0; i < nama.length; i++){
            System.out.println(nama[i]);
        }

    }

}
