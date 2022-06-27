package com.company;


import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static ConcurrentLinkedQueue<Caller> callers;
    public static LinkedList<Operator> operators;

    public static void main(String[] args) {



        System.out.println("Сколько клиентов?");
        Scanner sc = new Scanner(System.in);
        int callerCount = sc.nextInt();

        System.out.println("А операторов?");
        int operCount = sc.nextInt();

        if(callerCount > 0) {
            callers = new ConcurrentLinkedQueue<>();
            for (int i = 0; i < callerCount; i++)
                callers.add(new Caller(i+1));
        }

        if(operCount > 0) {
            operators = new LinkedList<>();
            System.out.println("Колл-центр начал свою работу");
            for (int i = 0; i < operCount; i++) {
                operators.add(new Operator(i+1));
            }
        }



    }
}