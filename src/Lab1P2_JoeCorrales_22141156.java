// Hecho por Joe Corrales 1/21/2022

import java.util.Scanner;

public class Lab1P2_JoeCorrales_22141156 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese las filas: ");
        int N = input.nextInt();
        System.out.print("Ingrese las columnas: ");
        int M = input.nextInt();
        System.out.print("Ingrese el valor de epsilon: ");
        double epsilon = input.nextInt();
        double delta = Math.pow(10, -epsilon);
        System.out.println(delta);
        double[][] matrizNum = new double[N][M];
        numRandom(matrizNum);
        imprimirMatriz(matrizNum, "[=== Matriz generada ===]");
        buscarRaices(matrizNum, delta);
    }

    //Funcion para generar un numero del 1 al 100 y asignarlo
    public static void numRandom(double[][] matriz) {
        for (int fi = 0; fi < matriz.length; fi++) {
            for (int co = 0; co < matriz[fi].length; co++)
                matriz[fi][co] = (int) (Math.random() * 100 + 1);
            System.out.println("\n");
        }
    }

    //Funcion para imprimir la matriz
    public static void imprimirMatriz(double[][] matriz, String mensaje) {
        System.out.println("\t  "+mensaje+"\n");
        for (int fi = 0; fi < matriz.length; fi++) {
            for (int co = 0; co < matriz[fi].length; co++)
                System.out.print("  ["+matriz[fi][co]+"]  ");
            System.out.println("\n");
        }
    }

    public static void buscarRaices(double[][] matriz, double error) {
        double[][] matrizRaices = new double[matriz.length][matriz[0].length];
        for (int fi = 0; fi < matriz.length; fi++) {
            for (int co = 0; co < matriz[fi].length; co++)
                matrizRaices[fi][co] = busquedaBinaria(matriz[fi][co], matriz[fi][co], 0, error);
        }
        imprimirMatriz(matrizRaices, "[=== Matriz De Raices ===]");
    }

    public static double busquedaBinaria(double x, double rmax, double rmin, double error) {
        double rmed = 0;
        rmed = (rmax + rmin)/2;
        double rmed2 = Math.pow(rmed,2);
        if (x - error <= rmed2 && rmed2 <= x + error){
            return rmed;
        } else {
            if(rmed2 < x)
                return busquedaBinaria(x, rmax, rmed, error);
            else
                return busquedaBinaria(x, rmed, rmin, error);
        }
    }
}
