/*
 * https://www.youtube.com/watch?v=gQb3dE-y1S4
 * TIC TAC TOE GAME
 
 */
package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] zaidimoLenta
                = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        Scanner scan = new Scanner(System.in);
        System.out.println("Tavo ejimas, pasirink pozicija (nuo 1 iki 9)");
        int zaidejoPozicija = scan.nextInt();
        
       
        
        ejimoVieta(zaidimoLenta, zaidejoPozicija, "zaidejas");  /* Iskvieciam METODA ejimoVieta*/
        
        Random rand = new Random();
        int cpuEjimas = rand.nextInt(9) + 1;
        ejimoVieta(zaidimoLenta, cpuEjimas, "CPU");

        printZaidimoLenta(zaidimoLenta);
        /*Spausdinimo lentos metodo iskvietimas*/

    }

    public static void printZaidimoLenta(char[][] zaidimoLenta) {
        /*sitas metodas spausdina lenta*/
        for (char[] eile : zaidimoLenta) {
            for (char c : eile) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    /* metodas, kuris atspausdina X zaidimu lentoj;*/
    public static void ejimoVieta(char[][] zaidimoLenta, int pozicija, String naudotojas) { 
        
        
        char symbol = ' ';
        if(naudotojas.equals("zaidejas")) {
            symbol = 'X';
        }
        else if(naudotojas.equals("CPU")){
        symbol = 'O';
        }
        switch (pozicija) {
            /* switch yra tas pats kaip IF ELSE*/
            case 1:
                zaidimoLenta[0][0] = symbol;
                break;
            case 2:
                zaidimoLenta[0][2] = symbol;
                break;
            case 3:
                zaidimoLenta[0][4] = symbol;
                break;
            case 4:
                zaidimoLenta[2][0] = symbol;
                break;
            case 5:
                zaidimoLenta[2][2] = symbol;
                break;
            case 6:
                zaidimoLenta[2][4] = symbol;
                break;
            case 7:
                zaidimoLenta[4][0] = symbol;
                break;
            case 8:
                zaidimoLenta[4][2] = symbol;
                break;
            case 9:
                zaidimoLenta[4][4] = symbol;
                break;
                
            default:  /*Default naudojamas visada gale po SWITCH*/ 
                break;
        }
    }
}
