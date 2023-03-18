package com.hacktiv8.tugas2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView counterText;
    private Button counterBtn;
    private EditText input_text;

    private int counter = 0;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.counterBtn:
                    buttonCounter();
                    break;
            }
        }
    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("result",counter);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterText= (TextView) findViewById(R.id.counterText);
        counterBtn= (Button) findViewById(R.id.counterBtn);
        counterBtn.setOnClickListener(clickListener);
        input_text= (EditText) findViewById(R.id.input_text);

        if (savedInstanceState != null){
            counter = savedInstanceState.getInt("result");
            counterText.setText(Integer.toString(counter));
        }
    }
    private void initCounter(){
        counter = 0;
        counterText.setText(counter+ "");
    }
    private void buttonCounter(){
        counter++;
        counterText.setText(counter+"");
    }
}