package PROG_Boletin_10;

public class Main {

    public static void main(String[] args) {
        Methods.intro();
        do {
            Methods.startGame();
        } while (Methods.restart());
        System.exit(0);
    }
}
