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

public class Main {

    public static void main(String[] args) {
        Methods.intro();
        do {
            Methods.startGame();
        } while (Methods.restart());
        System.exit(0);
    }
}
