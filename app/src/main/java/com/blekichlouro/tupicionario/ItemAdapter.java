package com.blekichlouro.tupicionario;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bubub on 18/01/2018.
 */

public class ItemAdapter extends ArrayAdapter<Item> { //ItemAdapter vai herdar as caracteristicas da ArrayAdapter
    private int backgroundColor;

    //Criar um construtor: passo: o contexto, lista de itens e cor de fundo:
    public ItemAdapter(Context context, ArrayList<Item> list, int backgroundColor ){
    //Vou chamar o metodo da classe pai com context, 0 para layout e lista:
        super(context,0, list);
        this.backgroundColor = backgroundColor;
    }//qdo o arrayadapter for chamado, jah vai criar o item com estes parametros.

    public View getView(int position, View convertView, ViewGroup parent ){
        //Cada linha da nossa lista eh um convertView e o ViewGroup eh a view raiz;
        //Vou passar o convertView para uma variavel:
        View itemView = convertView;
        //Verifico se a view estah nula, se sim eh pq ainda nao criei nenhuma view ainda
        //Entao vou inflar a view:
        if (itemView == null){
            //Vou inflar = o inflate pega o xml e transforma em layout;
            // Parametros: layout que criei, a view raiz e o false (para n'ao atrelar esta view com a view root, a principal)
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //Recupero o item a partir da posicao:
            Item item = getItem(position);

        //Recupero as views do layout pra setar os dados do item:
        TextView titulo =  (TextView) itemView.findViewById(R.id.item_titulo);
        titulo.setText(item.getTitulo());

        TextView desc = (TextView) itemView.findViewById(R.id.item_desc);
        desc.setText(item.getDescricao());

        ImageView icone = (ImageView) itemView.findViewById(R.id.item_icone);
        icone.setImageResource(item.getImagem());

        //Recuperar o layout de textos para fazer com que ele fique da cor da tela inicial:
        LinearLayout layoutTextos = (LinearLayout) itemView.findViewById(R.id.item_layout_textos);
        //Pegar e setar a cor neste layout:
        int cor = ContextCompat.getColor(getContext(), backgroundColor);
        layoutTextos.setBackgroundColor(cor);

        return itemView;
    }
}
