package com.blekichlouro.tupicionario;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Created by bubub on 06/01/2018.
 */

public class BichosActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//
        // Setando o layout bichos :
        setContentView(R.layout.activity_bichos);

        //Chamando as arrays criadas no strings.xml, a bichos e descricao de bichos:
        String[] bichosArray = getResources().getStringArray(R.array.bichos);
        final String[]bichosDescArray = getResources().getStringArray(R.array.bichos_desc);

        //Crio uma lista
        ArrayList<Item>list = new ArrayList<>();
        for (int i=0; i< 10; i++) {
            //Crio um novo item com os atributos que preciso (o construtor que fizemos)
            String titulo = bichosArray[i];
            String desc = bichosDescArray[i];
            Item item = new Item(titulo, desc, R.drawable.ic_bichos);
            //Cada item que criar jah adiciona na lista;
            list.add(item);

        }

        //Usando o ArrayAdapter que criamos e passando o array pra ele:
        ItemAdapter adapter = new ItemAdapter(this, list, R.color.bichos_categoria );

        //Recuperando o layout root de bichos:
        ListView listView = (ListView) findViewById(R.id.rootbichos);
        //Setando o click na lista:
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String desc = bichosDescArray[position];
                Toast.makeText(BichosActivity.this, desc, Toast.LENGTH_LONG).show();
           }
       });
        //Vou setar o adapter na listView:
        listView.setAdapter(adapter);

    }
}
//OnItemClickListener:
//parent = adapterView, View que to clicando,
//position da view e o id dela;