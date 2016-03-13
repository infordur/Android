package rafa.edu.gridview;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton[] botones = new ImageButton[4];
    MediaPlayer mp;
    Boolean seguir = true;
    ArrayList<Integer> pulsaciones = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botones[0] = (ImageButton) findViewById(R.id.gato);
        botones[1] = (ImageButton) findViewById(R.id.perro);
        botones[2] = (ImageButton) findViewById(R.id.gallo);
        botones[3] = (ImageButton) findViewById(R.id.vaca);

        for(int i = 0; i<botones.length;i++){

            botones[i].setOnClickListener(this);
        }

        jugar();
    }

    private void jugar() {
        generarBotonClick();

    }

    private void generarBotonClick() {
        int aleatorio = (int) Math.floor(Math.random() * 4);
        int identificador = 0;
        switch (aleatorio){
            case 0:
                identificador=R.id.gato;
                if (mp != null)
                    mp.stop();
                mp = MediaPlayer.create(this, R.raw.gato);
                mp.start();
                break;
            case 1:
                identificador=R.id.perro;
                if (mp != null)
                    mp.stop();
                mp = MediaPlayer.create(this, R.raw.perro);
                mp.start();
                break;
            case 2:
                identificador=R.id.gallo;
                if (mp != null)
                    mp.stop();
                mp = MediaPlayer.create(this, R.raw.gallo);
                mp.start();
                break;
            case 3:
                identificador=R.id.vaca;
                if (mp != null)
                    mp.stop();
                mp = MediaPlayer.create(this, R.raw.vaca);
                mp.start();
                break;
        }
        pulsaciones.add(identificador);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gato:
                Log.i("test gato", "meow");
                if (mp != null)
                    mp.stop();
                 mp = MediaPlayer.create(this, R.raw.gato);
                mp.start();
                break;
            case R.id.perro:
                Log.i("test perro", "guau");
                if (mp != null)
                    mp.stop();
                mp = MediaPlayer.create(this, R.raw.perro);
                mp.start();
                break;
            case R.id.gallo:
                Log.i("test gallo", "kikiriki");
                if (mp != null)
                    mp.stop();
                mp = MediaPlayer.create(this, R.raw.gallo);
                mp.start();
                break;
            case R.id.vaca:
                Log.i("test vaca", "muuu");
                if (mp != null)
                    mp.stop();
                mp = MediaPlayer.create(this, R.raw.vaca);
                mp.start();
                break;
        }
    }
}
