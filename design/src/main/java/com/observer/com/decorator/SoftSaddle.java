package com.observer.com.decorator;

public class SoftSaddle extends SaddleDecorator{

    public SoftSaddle(Saddle saddle) {
        super(saddle);
    }

    public void comfortLevel(Integer hard, Integer soft) {
        System.out.println("套上一个软坐垫软度为："+soft);
        super.comfortLevel(hard - soft);
    }
}
