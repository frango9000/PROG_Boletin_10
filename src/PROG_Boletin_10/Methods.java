package PROG_Boletin_10;


import javax.swing.*;
import java.util.Random;

public class Methods {


    public static void intro() {
        JOptionPane.showConfirmDialog(null, "Juego adivina el numero:\nEl jugador 2 introduce un numero secreto entre 1 y 50.\nLuego el jugador 1 intenta adivinarlo.\nLa unica pista sera si el numero es mayor o menor al secreto.", "Boletin 10", JOptionPane.DEFAULT_OPTION);
    }
    public static int introCode(String label, String jugador, String msg){
        return Integer.parseInt(JOptionPane.showInputDialog(null, label+"\n"+jugador+"\n"+msg, "Boletin 10", 3));
    }

    public static int askValidCode(String jugador, String msg){
        int i=0;
        String label="";
        do {
            i=introCode(label, jugador, msg);
            label="Error\n";
        }while(i<1||i>50);
        return i;
    }
    public static void hint(String str){
        JOptionPane.showConfirmDialog(null, str, "Boletin 10", JOptionPane.DEFAULT_OPTION);

    }
    public static void startGame(){
        int code, decode=0, tries;
        if(!pickOponent()) {
            code = askValidCode("Jugador 2", "Introduce un numero secreto entre 1 y 50");
            tries = askValidCode("Jugador 2", "Numero de intentos maximos");
        }else{
            Random rand = new Random();
            code = rand.nextInt(49)+1;
            tries=10;
        }
        do{
            decode = askValidCode("Jugador 1", "Introduce un numero secreto entre 1 y 50");
            if (decode>code)hint("Tu numero (" + decode + ") es mayor que el numero secreto\nIntentos restantes: "+tries);
            else if (decode<code)hint("Tu numero (" + decode + ") es menor que el numero secreto\nIntentos restantes: "+tries);
            else break;
            tries--;
        }while(decode!=code && tries !=0);
        if(code==decode)hint("Jugador 1 ha ganado!\nHa acertado el numero secreto");
        else hint("Jugador 2 ha ganado!\nJugador 1 no encontro el numero secreto.");

    }
    public static boolean restart(){
        String[] options = {"SI", "NO"};

        int newg = JOptionPane.showOptionDialog(null, "Nuevo Juego?", "Boletin 10", 0,3,null, options, 0);
        switch (newg) {
            case 0:
                return true;
            default:
                return false;
        }

    }
    public static boolean pickOponent(){
        String[] options = {"AI", "Humano"};

        int newg = JOptionPane.showOptionDialog(null, "Elije Oponente?", "Boletin 10", 0,3,null, options, 0);
        switch (newg) {
            case 0:
                return true;
            default:
                return false;
        }

    }








}
