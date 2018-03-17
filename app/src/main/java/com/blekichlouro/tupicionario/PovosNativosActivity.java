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

public class PovosNativosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_povos_nativos);

        //Chamando as arrays:
        String[] povosnativosArray = getResources().getStringArray(R.array.povosnativos);
        final String[] povosnativosDescArray = getResources().getStringArray(R.array.povosnativos_desc);

        //Crio uma lista:
        ArrayList<Item> list = new ArrayList<>();

        //Crio passando as arrays a serem incrementadas, criando o item que recebe as arrays e adicionando na lista
        for (int i = 0; i < 10; i++){
            String titulo = povosnativosArray[i];
            String desc = povosnativosDescArray[i];

            Item item = new Item(titulo, desc, R.drawable.ic_povos_nativos);
            list.add(item);
        }
        //Criand o adapter com contexto, lista e cor de fundo:
        ItemAdapter adapter = new ItemAdapter(this, list, R.color.povos_nativos_categoria);
        //Recupero o listview root dos povos nativos
        ListView listView = (ListView) findViewById(R.id.rootpovosnativos);
        //Seto o adapter nele:
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String desc = povosnativosDescArray[position];
                Toast.makeText(PovosNativosActivity.this, desc, Toast.LENGTH_LONG).show();
            }
        });

    }
}
