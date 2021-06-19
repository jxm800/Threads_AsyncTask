package com.example.threads_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RunnablePostMethodActivity extends AppCompatActivity implements Runnable {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runnable_post_method);

        button = findViewById(R.id.button);
    }

    public void onClick(View view) {
        run();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            button.post(new Update());
    }

    class Update implements Runnable {
        public void run() {
            button.setText("Finished!");
        }
    }
}
