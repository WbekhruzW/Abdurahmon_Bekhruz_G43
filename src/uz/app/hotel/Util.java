package uz.app.hotel;


import java.util.Scanner;

public class Util {



    public static String[]args;
    public static Scanner scanner = new Scanner(System.in);
    public static Scanner srtScanner = new Scanner(System.in);
    public static String getLine(String text){
        System.out.println(text);
        return srtScanner.nextLine();
    }
    public static int getInt(String text){
        System.out.println(text);
        return scanner.nextInt();
    }
}

