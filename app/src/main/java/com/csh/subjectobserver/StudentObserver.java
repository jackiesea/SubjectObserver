package com.csh.subjectobserver;

public class StudentObserver implements Observer {
    private TeacherSubject teacherSubjectInstance;
    //不同观察者对象
    private String observerName;
    //每个观察者可以把得到的主题回调信息给上层activity使用
    private CallBack callBack;

    //构造注册每一个观察者
    public StudentObserver(String observerName, TeacherSubject teacherSubject, CallBack callBack) {
        this.observerName = observerName;
        this.teacherSubjectInstance = teacherSubject;
        this.callBack = callBack;
        //将每个生成的观察者对象添加到观察队列
        teacherSubject.addObserver(this);
    }

    @Override
    public void update(String subject) {
        callBack.onResponse(observerName + " 得到的主题是：" + subject);
    }
}
