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

public class CulinariaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culinaria);

        //Chamndo a array de culinaria e a descricao:
        String[] culinariaArray = getResources().getStringArray(R.array.culinaria);
        final String[] culinariaDescArray = getResources().getStringArray(R.array.culinaria_desc);

        //Criar uma lista:
        ArrayList<Item> list = new ArrayList<>();

        // Adicionando as arrays de texto, criando cada item e adicionando na lista:
        for(int i =0; i< 10; i++){
            String titulo = culinariaArray[i];
            final String desc = culinariaDescArray[i];

            Item item = new Item(titulo, desc, R.drawable.ic_culinaria);
            list.add(item);
            }

        //Criar um adapter do tipo q criamos c/ os parametros: contexto,
        ItemAdapter adapter = new ItemAdapter(this, list, R.color.culinaria_categoria);

        //Recuperar o layout root de culinaria:
        ListView listView = (ListView) findViewById(R.id.rootculinaria);
        //Setando o click na lista:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String desc = culinariaDescArray[position];
                Toast.makeText(CulinariaActivity.this, desc, Toast.LENGTH_LONG).show();
            }
        });

        listView.setAdapter(adapter);
    }
}
