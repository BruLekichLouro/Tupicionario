package com.blekichlouro.tupicionario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlantasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantas);

        //Chamando a array de plantas e de descricao:
        String[] plantasArray = getResources().getStringArray(R.array.plantas);
        final String[] plantasDescArray = getResources().getStringArray(R.array.plantas_desc);
        //Criando lista:
        ArrayList<Item> list =new ArrayList<>();
        //For pra preencher a lista com item e incrmenntar posicao do array de plantas e de descricao de plantas
        for (int i = 0; i<10 ; i++){
            String titulo = plantasArray[i];
            String desc = plantasDescArray[i];

            Item item = new Item(titulo, desc, R.drawable.ic_plantas );
            list.add(item);
        }

        //Crio um ItemAdapter e passo o contexto, a lista e a cor de fundo:
        ItemAdapter adapter = new ItemAdapter(this, list, R.color.plantas_categoria);

        //Recupero o layout root de plantas:
        ListView listView =  (ListView) findViewById(R.id.rootplantas);
        //Seto o Adapter no listView:
        listView.setAdapter(adapter);

        //Seto o click nele com: java  de contexto, array de descricao e show:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String desc = plantasDescArray[position];
                Toast.makeText(PlantasActivity.this, desc, Toast.LENGTH_LONG).show();
            }
        });
    }
}
