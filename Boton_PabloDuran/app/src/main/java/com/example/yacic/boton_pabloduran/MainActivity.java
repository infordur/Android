package com.example.yacic.boton_pabloduran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.xmlpull.v1.XmlSerializer;

public class MainActivity extends AppCompatActivity {

    TextView vText;
    Button button = (Button) findViewById(R.id.button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                vText = (TextView) findViewById(R.id.textView);
                vText.setText("Boton Pulsado");
            }
        });
    }

}
