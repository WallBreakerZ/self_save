package com.observer.specific_observer;

import com.observer.Observer;

/**
 * 轮毂
 *
 * @author ZYH on 2022/9/19
 */
public class WheelObsever implements Observer {
    @Override
    public void update(int state) {
        if (state == 1){
            System.out.println("升级自行车轮毂");
        }else {
            System.out.println("降低自行车轮毂");
        }
    }
}
