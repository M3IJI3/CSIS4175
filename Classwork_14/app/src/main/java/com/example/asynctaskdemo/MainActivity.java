package com.example.asynctaskdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        myTextView = findViewById(R.id.textView);

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void buttonCLick(View view) {
        new MyTask().execute();

//        AsyncTask task = new MyTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//        int cpu_cores = Runtime.getRuntime().availableProcessors();
    }

    private class MyTask extends AsyncTask<String, Integer, String>
    {
        @Override
        protected void onProgressUpdate(Integer... values) {
            myTextView.setText("Counter = " + values[0]);
        }

        @Override
        protected String doInBackground(String... strings) {
            int i = 0;
            while(i <= 10)
            {
                publishProgress(i);
                try{
                    Thread.sleep(1000);
                    i++;
                } catch (Exception e)
                {

                }
            }
            return "Button Pressed.";
        }

        @Override
        protected void onPostExecute(String s) {
            myTextView.setText(s);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }
}