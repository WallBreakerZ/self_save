package com.observer.com.decorator;

public class SaddleDecorator implements ComfortCalculate{
    private Saddle saddle;
    public SaddleDecorator(Saddle saddle){
        this.saddle = saddle;
    }

    @Override
    public void comfortLevel(Integer hard) {
        System.out.println("硬度为："+hard);
        saddle.comfortLevel(hard);
    }
}
