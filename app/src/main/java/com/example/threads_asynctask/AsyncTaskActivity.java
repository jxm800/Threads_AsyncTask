package com.example.threads_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncTaskActivity extends AppCompatActivity {

    Button button;
    int waitTime;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.text);
        waitTime = 3;
    }

    public void onClick(View view) {
        new TestAsyncTask().execute(waitTime);
    }

    public class TestAsyncTask extends AsyncTask<Integer, String, String> {

        private String finalText;

        @Override
        protected void onPreExecute() {
            Toast.makeText(getBaseContext(), "Wait for "+waitTime+" seconds", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(Integer... params) {
            publishProgress("Waiting...");
            try {
                int time = (params[0]) * 1000;
                Thread.sleep(time);
                finalText = "Waited for " + params[0] + " seconds";
            } catch (Exception e) {
                e.printStackTrace();
                finalText = e.getMessage();
            }
            return finalText;
        }

        @Override
        protected void onProgressUpdate(String... text) {
            textView.setText(text[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            textView.setText(result);
        }
    }
}
