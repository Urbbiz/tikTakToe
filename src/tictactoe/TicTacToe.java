/*
 * https://www.youtube.com/watch?v=gQb3dE-y1S4
 * TIC TAC TOE GAME
 
 */
package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    
    static ArrayList<Integer> zaidejoVieta = new ArrayList<Integer>();
    static ArrayList<Integer> CPUvieta = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] zaidimoLenta
                = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Tavo ejimas, pasirink pozicija (nuo 1 iki 9)");
            int zaidejoPozicija = scan.nextInt();
            while(zaidejoVieta.contains(zaidejoPozicija) || CPUvieta.contains(zaidejoVieta)){
                System.out.println("Langelis uzimtas, pasirink kita");
                zaidejoPozicija = scan.nextInt();
            }

            ejimoVieta(zaidimoLenta, zaidejoPozicija, "zaidejas");
            /* Iskvieciam METODA ejimoVieta*/
            String rezultatas = laimetojoPatikrinimas();
            if(rezultatas.length() > 0){
                System.out.println(rezultatas);
                break;
            }

            Random rand = new Random();
            int cpuEjimas = rand.nextInt(9) + 1;
            while(zaidejoVieta.contains(cpuEjimas) || CPUvieta.contains(cpuEjimas)){
                cpuEjimas = rand.nextInt(9) + 1;
            }
            ejimoVieta(zaidimoLenta, cpuEjimas, "CPU");

            printZaidimoLenta(zaidimoLenta);
            /*Spausdinimo lentos metodo iskvietimas*/
            
           rezultatas = laimetojoPatikrinimas();
            if(rezultatas.length() > 0){
                System.out.println(rezultatas);
                break;
            
            }
            

        }
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
        if (naudotojas.equals("zaidejas")) {
            symbol = 'X';
            zaidejoVieta.add(pozicija);
        } else if (naudotojas.equals("CPU")) {
            symbol = 'O';
            CPUvieta.add(pozicija);
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

            default:
                /*Default naudojamas visada gale po SWITCH*/
                break;
        }
    }
    public static String laimetojoPatikrinimas(){
        
        List virsutineEile =Arrays.asList(1, 2, 3);
        List vidurineEile =Arrays.asList(4, 5, 6);
        List apatineEile =Arrays.asList(7, 8, 9);
        
        List kairysStulpelis =Arrays.asList(1, 4, 7);
        List vidurinisStulpelis =Arrays.asList(2, 5, 8);
        List desinysStulpelis =Arrays.asList(3, 6, 9);
        
        List istrizai1 =Arrays.asList(1, 5, 9);
        List istrizai2 =Arrays.asList(3, 5, 7);
        
        List<List> laimejimas = new ArrayList<List>();
        laimejimas.add(virsutineEile);
        laimejimas.add(vidurineEile);
        laimejimas.add(virsutineEile);
        
        laimejimas.add(kairysStulpelis);
        laimejimas.add(vidurinisStulpelis);
        laimejimas.add(desinysStulpelis);
        
        laimejimas.add(istrizai1);
        laimejimas.add(istrizai2);
        
        for(List l : laimejimas) {
        if(zaidejoVieta.containsAll(l)){
        return "Valiooo, LAIMEJAI smiki!!!!";
        } else if(CPUvieta.contains(l)) {
        return "CPU laimejo :((((";
        }else if (zaidejoVieta.size() + CPUvieta.size() == 9){
        return "LYGIOSIOS";
        }
        }
                
        
        
    return "";
    
    }
}
