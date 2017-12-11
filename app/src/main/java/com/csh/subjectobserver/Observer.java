package com.csh.subjectobserver;

public interface Observer {
    //主题状态改变，将一个String类型字符串传入该方法的参数，每个观察者都需要实现该方法
    void update(String info);
}
