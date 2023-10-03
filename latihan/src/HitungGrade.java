import java.util.Scanner;

public class HitungGrade {

    public static void main(String[] args) {

        int nilai;
        String grade;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inputkan nilai: ");
        nilai = scanner.nextInt();

        if ( nilai >= 90 ) {
            grade = "A";
        } else if ( nilai >= 80 ) {
            grade = "B+";
        } else if ( nilai >=  70 ) {
            grade = "B";
        } else if ( nilai >= 60 ) {
            grade = "C+";
        } else if ( nilai >= 50 ) {
            grade = "C";
        } else if ( nilai >= 40 ) {
            grade = "D";
        } else {
            grade = "E";
        }

        System.out.println("Nilai anda " + grade);

    }

}
