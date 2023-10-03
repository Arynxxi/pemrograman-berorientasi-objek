import java.util.Scanner;

public class ArrayGrade {

    public static void main(String[] args) {

        int nilai[] = new int[2];
        String grade[] = new String[2];
        Scanner scan = new Scanner(System.in);

        for ( int i = 0; i < 2; i++ ) {
            System.out.print("Input nilai: ");
            nilai[i] = scan.nextInt();

            if ( nilai[i] >= 90 ) {
                grade[i] = "A";
            } else if ( nilai[i] >= 80 ) {
                grade[i] = "B+";
            } else if ( nilai[i] >= 70 ) {
                grade[i] = "B+";
            } else if ( nilai[i] >= 60 ) {
                grade[i] = "C+";
            } else if ( nilai[i] >= 50 ) {
                grade[i] = "C";
            } else if ( nilai[i] >= 40 ) {
                grade[i] = "D";
            } else {
                grade[i] = "E";
            }
        }

        for ( int i = 0; i < 2; i++ ) {
            System.out.println("Grade ke-" + i + "= " + grade[i]);
        }

    }

}
