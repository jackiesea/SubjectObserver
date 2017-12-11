package com.csh.subjectobserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建一个订阅者（被观察者），多个观察者，将他们进行绑定在一起
        TeacherSubject teacherSubject = TeacherSubject.getTeacherSubjectInstance();

        StudentObserver studentObserver1 = new StudentObserver("观察者1号", teacherSubject, callback);
        StudentObserver studentObserver2 = new StudentObserver("观察者2号", teacherSubject, callback);
        StudentObserver studentObserver3 = new StudentObserver("观察者3号", teacherSubject, callback);

        /*//订阅者（被观察者）发布主题
        teacherSubject.publicSubject("吃饺子");*/
    }

    public void goToMain2(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }

    CallBack callback = new CallBack() {
        @Override
        public void onResponse(String info) {
            Log.e("", "Main onResponse " + info);
        }
    };
}
