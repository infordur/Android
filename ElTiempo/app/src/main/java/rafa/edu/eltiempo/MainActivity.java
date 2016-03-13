package rafa.edu.eltiempo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView ciudad,temp,humedad;
    ImageView estado;
    Button boton;
    EditText campo;
    ParseDom parseDom;
    Ciudad ciudadBuscada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ciudad = (TextView) findViewById(R.id.ciudad);
        temp = (TextView) findViewById(R.id.temperatura);
        humedad = (TextView) findViewById(R.id.humedad);

        boton = (Button) findViewById(R.id.buscar);
        campo = (EditText) findViewById(R.id.campo);
        estado = (ImageView) findViewById(R.id.estadoTiempo);

        boton.setOnClickListener(this);

        parseDom = new ParseDom("http://api.openweathermap.org/data/2.5/weather?q=cordoba,es&mode=xml&appid=0f3eac7386b2752442fe29452a26cdc7");
        ciudadBuscada = parseDom.parse();
        imprimirDatos(ciudadBuscada);

    }

    @Override
    public void onClick(View v) {
         String busqueda = campo.getText().toString();
        if(busqueda.trim().length()<=0){
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Escriba una ciudad", Toast.LENGTH_SHORT);

            toast1.show();
        }else{
            if (!busqueda.contains(","))
                busqueda+=",es";
            parseDom = new ParseDom("http://api.openweathermap.org/data/2.5/weather?q="+busqueda+"&mode=xml&appid=0f3eac7386b2752442fe29452a26cdc7");
            ciudadBuscada = parseDom.parse();
            if(parseDom.isCreado()){
             imprimirDatos(ciudadBuscada);
            }else{
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "La ciudad no existe", Toast.LENGTH_SHORT);

                toast1.show();
            }

        }

    }

    public void imprimirDatos(Ciudad lugar){

            ciudad.setText(lugar.getNombre()+" - "+ lugar.getPais());
            temp.setText(lugar.getTemp());
            humedad.setText(lugar.getHumedad());
            switch (lugar.getEstadoTiempo()) {
                case "clear sky":
                    estado.setImageResource(R.drawable.sun);
                    break;
                case "few clouds":
                case "scattered clouds":
                    estado.setImageResource(R.drawable.cloud);
                    break;
                case "broken clouds":
                    estado.setImageResource(R.drawable.brokencloud);
                    break;
                case "shower clouds":
                case "rain":
                    estado.setImageResource(R.drawable.rain);
                    break;
                case "snow":
                    estado.setImageResource(R.drawable.snow);
                    break;
                case "thunderstorm":
                    estado.setImageResource(R.drawable.storm);
                    break;
            }

        }


}

