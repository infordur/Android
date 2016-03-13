package com.example.yacic.adaptador1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvLista;
    ArrayList<Zona> listaZonas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLista= (ListView) findViewById(R.id.lista);
        listaZonas=new ArrayList<Zona>();

        listaZonas.add(new Zona("Mezquita", "La Mezquita-catedral de Córdoba, antes «Santa María Madre de Dios» o «Gran Mezquita de Córdoba», actualmente conocida como la Catedral de la Asunción de Nuestra Señora de forma eclesiástica, o simplemente Mezquita de Córdoba de forma general, es un edificio de la ciudad de Córdoba, España. Se trata de uno de los monumentos más importantes de la arquitectura islámica en España, así como del más emblemático ejemplo de arte omeya hispanomusulmán. Desde el siglo XIII y hasta la actualidad es un templo católico, la iglesia catedral de la diócesis de Córdoba. Está declarado Patrimonio Cultural de la Humanidad como parte del centro histórico de la ciudad.", R.drawable.mezquita));
        listaZonas.add(new Zona("Puente Romano", "El puente romano de Córdoba está situado sobre el río Guadalquivir a su paso por Córdoba, y une el barrio del Campo de la Verdad con el Barrio de la Catedral. También conocido como \"el Puente Viejo\" fue el único puente con que contó la ciudad durante 20 siglos, hasta la construcción del puente de San Rafael, a mediados del siglo XX. El 9 de enero de 2008 se inauguró la mayor y discutida remodelación que el puente Romano ha tenido en su historia.", R.drawable.puenteromano));
        listaZonas.add(new Zona("Torre de la Calahorra", "La Torre de la Calahorra (en árabe: qala’at al-hurriya) es una fortaleza de origen islámico concebida como entrada y protección del Puente Romano de Córdoba (España). Fue declarada Conjunto Histórico-Artístico en 1931, junto con el puente romano y la puerta del puente.1 Forma parte del centro histórico de Córdoba que fue declarado Patrimonio de la Humanidad por la Unesco en 1994.2", R.drawable.calahorra));
        listaZonas.add(new Zona("Alcazar de los Reyes Cristianos","El Alcázar de los Reyes Cristianos, es un edificio de carácter militar ordenado construir por el rey Alfonso XI de Castilla en el año 1328, sobre construcciones anteriores (el Alcázar andalusí, antes residencia del Gobernador Romano y la Aduana, ubicada en uno de los márgenes del río Guadalquivir), en Córdoba, España. El conjunto arquitectónico tiene un carácter sobrio en su exterior y espléndido en su interior, con los magníficos jardines y patios que mantienen una inspiración mudéjar.",R.drawable.alcazar));
        lvLista.setAdapter(new adaptador(this, listaZonas));


        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Creamos intentción para poder ir a otra actividad.
                Intent intent=new Intent(MainActivity.this,actividad.class);
                //Creamos el bundle donde vamos a guardar los objeto
                Bundle zona=new Bundle();
                //Guardamos el objeto en el bundle
                zona.putSerializable("zona",listaZonas.get(position));
                //Añadimos el bundle en el intent
                intent.putExtras(zona);
                //Comenzamos la activiad
                startActivity(intent);
            }
        });
    }
}
