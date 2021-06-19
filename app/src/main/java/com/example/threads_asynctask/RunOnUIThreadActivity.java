package com.example.threads_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RunOnUIThreadActivity extends AppCompatActivity implements Runnable {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_on_ui_thread);

        button = findViewById(R.id.button);
    }

    public void onClick(View view) {
        button.setText("Waiting...");
        button.setEnabled(false);

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        runOnUiThread(new Update());
    }

    class Update implements Runnable {
        // This action is posted to event queue
        public void run() {
            button.setText("Finished!");
            button.setEnabled(true);
        }
    }
}


