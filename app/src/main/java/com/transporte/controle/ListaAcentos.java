package com.transporte.controle;


import android.app.Activity;
import android.app.ListFragment;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaAcentos extends ListFragment {


    static interface InterfaceDaLista{
        void itemClicked(long id);


    };

    private InterfaceDaLista listaOuvinte;

    //DataBase db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            //db=new DataBase(getActivity());

            //String[] nomes = new String[0];
        String[] nomes = new String[DadosPassageiros.lugar.length];
        for(int i = 0; i< nomes.length; i++) {

            if (DadosPassageiros.lugar[i].getNome() != null) {

                nomes[i] = DadosPassageiros.lugar[i].getAcento()
                        + "\n" + DadosPassageiros.lugar[i].getNome();
            } else {
                nomes[i] = DadosPassageiros.lugar[i].getAcento();
            }
        }

        /*for(int i = 0; i> nomes.length; i++){
             nomes = new String[db.PesquisarWord("nome", i,1).size()];
           
             //aqui ele pega os acentos e coloca na lista
            if(nomes[i] != null){
                
                nomes[i] = String.valueOf(db.PesquisarWord("nome", i,1));

            }
        }*/

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1, nomes

        );


        setListAdapter(adapter);

        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
                //inflater.inflate(R.layout.fragment_lista_acentos2, container, false);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.listaOuvinte = (InterfaceDaLista) activity;

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        if(listaOuvinte !=null){
            listaOuvinte.itemClicked(id);


        }
    }
    public ListaAcentos() {
        // Required empty public constructor
    }


}
