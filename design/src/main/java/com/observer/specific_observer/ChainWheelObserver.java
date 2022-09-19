package com.observer.specific_observer;

import com.observer.Observer;

/**
 * 自行车牙盘
 *
 * @author ZYH on 2022/9/19
 */
public class ChainWheelObserver implements Observer {
    @Override
    public void update(int state) {
        if (state == 1){
            System.out.println("升级自行车牙盘");
        }else {
            System.out.println("降低自行车牙盘");
        }
    }
}
