package com.company;

import static com.company.Main.callers;

public class Operator implements Runnable {
    int id;
    int state; //0 - свободен, 1 - занят, 2 - кончил

    public Operator(int id) {
        this.state = 0;
        this.id = id;
        talk();
    }

    void talk() {

        Thread thread = new Thread(this);
        thread.start();


    }

    void end() {
        System.out.println("Оператор "+id+" закончил");
        this.state = 2;
        Main.operators.remove(this);
        synchronized (Main.operators) {
            if(Main.operators.isEmpty()) System.out.println("Колл-центр закончил");
        }

    }

    @Override
    public void run() {
        System.out.println("Оператор "+id+" начал");
        while(state<2) {
            Caller myCaller = callers.poll();
            if (myCaller == null) end();
            else {
                System.out.println("Оператор " + id + " разговаривает с звонящим " + myCaller.id);
                try {
                    Thread.sleep((long) (Math.random() * 4999 + 1001));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
