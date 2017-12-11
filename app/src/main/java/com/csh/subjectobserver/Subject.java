package com.csh.subjectobserver;

public interface Subject {
    //添加观察者
    void addObserver(Observer observer);

    //移除观察者
    void removeObserver(Observer observer);

    //主题方法改变，通知所有的观察者
    void notifyObserver();
}
