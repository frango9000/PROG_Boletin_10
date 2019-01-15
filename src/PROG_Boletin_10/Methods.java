/*
    This file is part of PROG_Boletin_10.

    PROG_Boletin_10 is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    PROG_Boletin_10 is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <https://www.gnu.org/licenses/>.


*/

package PROG_Boletin_10;

import javax.swing.*;
import java.util.Random;

public class Methods {

    public static void intro() {
        JOptionPane.showConfirmDialog(null, "Juego adivina el numero:\nEl jugador 2 introduce un numero secreto entre 1 y 50.\nLuego el jugador 1 intenta adivinarlo.\nLa unica pista sera si el numero es mayor o menor al secreto.", "Boletin 10", JOptionPane.DEFAULT_OPTION);
    }

    public static int introCode(String label, String jugador, String msg) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, label + "\n" + jugador + "\n" + msg, "Boletin 10", 3));
    }

    public static int askValidCode(String jugador, String msg) {
        int i = 0;
        String label = "";
        do {
            i = introCode(label, jugador, msg);
            label = "Error\n";
        } while (i < 1 || i > 50);
        return i;
    }

    public static void hint(String str) {
        JOptionPane.showConfirmDialog(null, str, "Boletin 10", JOptionPane.DEFAULT_OPTION);

    }

    public static void startGame() {
        int code, decode = 0, tries;
        if (!pickOponent()) {
            code = askValidCode("Jugador 2", "Introduce un numero secreto entre 1 y 50");
            tries = askValidCode("Jugador 2", "Numero de intentos maximos");
        } else {
            Random rand = new Random();
            code = rand.nextInt(49) + 1;
            tries = 10;
        }
        do {
            decode = askValidCode("Jugador 1", "Introduce un numero secreto entre 1 y 50");
            if (decode > code) {
                hint("Tu numero (" + decode + ") es mayor que el numero secreto\n" + diference(decode, code) + "\nIntentos restantes: " + tries);
            } else if (decode < code) {
                hint("Tu numero (" + decode + ") es menor que el numero secreto\n" + diference(decode, code) + "\nIntentos restantes: " + tries);
            } else {
                break;
            }
            tries--;
        } while (decode != code && tries != 0);
        if (code == decode) {
            hint("Jugador 1 ha ganado!\nHa acertado el numero secreto");
        } else {
            hint("Jugador 2 ha ganado!\nJugador 1 no encontro el numero secreto.");
        }

    }

    public static boolean restart() {
        String[] options = {"SI", "NO"};

        int newg = JOptionPane.showOptionDialog(null, "Nuevo Juego?", "Boletin 10", 0, 3, null, options, 0);
        switch (newg) {
            case 0:
                return true;
            default:
                return false;
        }

    }

    public static boolean pickOponent() {
        String[] options = {"AI", "Humano"};

        int newg = JOptionPane.showOptionDialog(null, "Elije Oponente?", "Boletin 10", 0, 3, null, options, 0);
        switch (newg) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public static String diference(int i, int j) {
        int k = Math.abs(i - j);
        if (k > 20) {
            return "moi lonxe";
        } else if (k <= 20 && k >= 10) {
            return "lonxe";
        } else if (k < 10 && k > 5) {
            return "preto";
        } else if (k <= 5 && k > 0) {
            return "moi preto";
        } else {
            return "";
        }
    }
}
