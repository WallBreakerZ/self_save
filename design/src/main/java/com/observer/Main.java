package com.observer;

import com.observer.specific_observer.BicycleHubsObserver;
import com.observer.specific_observer.ChainWheelObserver;
import com.observer.specific_observer.WheelObsever;

/**
 * 启动类
 *
 * @author ZYH on 2022/9/19
 */
public class Main {
    public static void main(String[] args) {
        BicycleTarget bicycleTarget = new BicycleTarget();
        bicycleTarget.addObserver(new WheelObsever());
        bicycleTarget.addObserver(new BicycleHubsObserver());
        bicycleTarget.addObserver(new ChainWheelObserver());
        bicycleTarget.events(1);
        System.out.println("###############");
        bicycleTarget.events(0);
    }
}
