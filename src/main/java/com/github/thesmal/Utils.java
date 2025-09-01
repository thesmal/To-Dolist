package com.github.thesmal;

import jdk.jshell.execution.Util;

import java.util.Scanner;

public class Utils {
    // Scanner
    public static final Scanner sc = new Scanner(System.in);

    // Output
    public static void print(String s){
        System.out.print(s);
    }
    public static void println(String s){
        System.out.println(s);
    }

    // String Input
    public static String input(){
        return sc.nextLine();
    }

    // Double Input
    public static double inputDouble() {
        return Double.parseDouble(sc.nextLine());
    }

    // Integer Input
    public static int inputInt() {
        return Integer.parseInt(sc.nextLine());
    }

    // Float Input
    public static float inputFloat() {
        return Float.parseFloat(sc.nextLine());
    }

    // Long Input
    public static long inputLong() {
        return Long.parseLong(sc.nextLine());
    }

    //Short Input
    public static short inputShort() {
        return Short.parseShort(sc.nextLine());
    }

    //Byte Input
    public static byte inputByte() {
        return Byte.parseByte(sc.nextLine());
    }

    // Loop
    public static void loop(int loopamount, Runnable action) {
        for (int i = 0; i < loopamount; i++) action.run();
    }

    // Calculation
    public static double calculate(char operator, double num1, double num2) {
        double answer = 0;
        switch (operator) {
            case '+' -> {
                answer = num1 + num2;
            }
            case '-' -> {
                answer = num1 - num2;
            }
            case '*' -> {
                answer = num1 * num2;
            }
            case '/' -> {
                answer = num1 / num2;
            }
            case '^' -> {
                answer = Math.pow(num1, num2);
            }
            case '%' -> {
                answer = num1 % num2;
            }
            default -> {
                answer = 000000000000000;
            }
        }
        return answer;
    }
}