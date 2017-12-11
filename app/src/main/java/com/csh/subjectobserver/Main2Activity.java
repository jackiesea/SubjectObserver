package com.csh.subjectobserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TeacherSubject teacherSubject = TeacherSubject.getTeacherSubjectInstance();

        StudentObserver studentObserver1 = new StudentObserver("观察者X号", teacherSubject, callback);
        //订阅者（被观察者）发布主题
        teacherSubject.publicSubject("吃饺子");
    }

    public void backToMain(View view) {
        finish();
    }

    CallBack callback = new CallBack() {
        @Override
        public void onResponse(String info) {
            Log.e("", "Main2 onResponse " + info);
        }
    };
}
