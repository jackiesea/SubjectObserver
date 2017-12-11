package com.csh.subjectobserver;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TeacherSubject implements Subject {
    //保存观察者
    private List<Observer> observers = new ArrayList<>();
    //主题
    private String subject;

    //改成单例模式，让所有activity都可以获得
    public static TeacherSubject mTeacherSubjectInstance;

    public static TeacherSubject getTeacherSubjectInstance() {
        if (mTeacherSubjectInstance == null) {
            mTeacherSubjectInstance = new TeacherSubject();
        }
        return mTeacherSubjectInstance;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(subject);
        }
    }

    //发布主题，通知所有观察者
    public void publicSubject(String subject) {
        this.subject = subject;
        Log.e("", "发布的主题是：" + subject);
        this.notifyObserver();
    }
}
