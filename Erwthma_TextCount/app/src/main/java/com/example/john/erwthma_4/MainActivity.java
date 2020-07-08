package com.example.john.erwthma_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText=(EditText) findViewById(R.id.editText);
                String userText= editText.getText().toString();
                //TextView textView= (TextView) findViewById(R.id.textView);
                //textView.setText(userText);
                Toast.makeText(getApplicationContext(),String.valueOf(userText.length()),Toast.LENGTH_LONG).show();
            }
        });
    }
}
