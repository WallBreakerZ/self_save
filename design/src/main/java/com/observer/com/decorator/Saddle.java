package com.observer.com.decorator;

/**
 * 自行车坐垫
 */
public class Saddle implements ComfortCalculate{

    @Override
    public void comfortLevel(Integer hard) {
        if(hard > 10){
            System.out.println("硌屁股");
        }else {
            System.out.println("舒服");
        }
    }
}
