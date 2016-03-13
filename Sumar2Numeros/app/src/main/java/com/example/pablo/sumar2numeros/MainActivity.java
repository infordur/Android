package com.example.pablo.sumar2numeros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int n1, n2, resultado;
    EditText sumando1, sumando2;
    TextView resultadoM;
    Button btnCalcular;
    RadioButton btnSumar, btnRestar, btnMultiplicar, btnDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumando1= (EditText) findViewById(R.id.numero1);
        sumando2= (EditText) findViewById(R.id.numero2);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        resultadoM = (TextView) findViewById(R.id.textResultado);

        btnSumar = (RadioButton) findViewById(R.id.btnSumar);
        btnRestar = (RadioButton) findViewById(R.id.btnRestar);
        btnMultiplicar = (RadioButton) findViewById(R.id.btnMultiplicar);
        btnDividir = (RadioButton) findViewById(R.id.btnDividir);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n1 = Integer.parseInt(sumando1.getText().toString());
                n2 = Integer.parseInt(sumando2.getText().toString());

                if(btnSumar.isChecked()) {
                    resultado = n1 + n2;
                }
                if(btnRestar.isChecked()){
                    resultado = n1 - n2;
                }
                if(btnMultiplicar.isChecked()){
                    resultado = n1 * n2;
                }
                if(btnDividir.isChecked() && n2!=0){
                    resultado = n1/n2;
                }

                resultadoM.setText(Integer.toString(resultado));
            }
        });
    }

}
