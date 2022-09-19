package com.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者的目标对象--自行车
 *
 * @author ZYH on 2022/9/19
 */
public class BicycleTarget {
    private List<Observer> observerList = new ArrayList<>();

    /**
     * 增加该目标对象的观察者
     * @param observer
     */
    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    public void events(Integer state){
        if (state == 1){
            System.out.println("升级自行车！");
            observerList.forEach(item->item.update(1));
        }else {
            System.out.println("降级自行车！");
            observerList.forEach(item->item.update(2));
        }
    }
}
