public class ClassArray {

    public static void main(String[] args) {

        String[] mobil = {"Toyota", "Honda", "Wuling", "Mitsubhisi"};
        mobil[0] = "Tesla";

        for (int i = 0; i < mobil.length; i++) {
            System.out.println(mobil[i]);
        }

    }

}
