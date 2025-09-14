package br.com.livraria.util;
import java.util.Scanner;

public class Teclado{
    public static int LerInteiro(String rotulo){
        System.out.println(rotulo);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
    public static double LerDouble(String rotulo){
        System.out.println(rotulo);
        Scanner scan = new Scanner(System.in);
        return scan.nextDouble();
    }
    public static String LerString(String rotulo){
        System.out.println(rotulo);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}