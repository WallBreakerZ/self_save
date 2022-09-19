package com.observer.specific_observer;

import com.observer.Observer;

/**
 * 自行车花鼓
 *
 * @author ZYH on 2022/9/19
 */
public class BicycleHubsObserver implements Observer {
    @Override
    public void update(int state) {
        if (state == 1){
            System.out.println("升级自行车花鼓");
        }else {
            System.out.println("降低自行车花鼓");
        }
    }
}
