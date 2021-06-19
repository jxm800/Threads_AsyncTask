package com.example.threads_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                intent = new Intent(this, RunOnUIThreadActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(this, RunnablePostMethodActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(this, AsyncTaskActivity.class);
                startActivity(intent);
                break;
        }
    }
}
