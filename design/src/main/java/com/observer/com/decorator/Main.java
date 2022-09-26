package com.observer.com.decorator;

public class Main {
    public static void main(String[] args) {
        SoftSaddle softSaddle = new SoftSaddle(new Saddle());
        softSaddle.comfortLevel(10 ,1);
    }
}
