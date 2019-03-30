package com.transporte.controle;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.content.IntentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetalhesPassageirosActivity extends Fragment implements View.OnClickListener {

    private long wordId;


   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle saveInstanceState){
       View layout = inflater.inflate(R.layout.fragment_detalhes_passageiros,
               container, false);

        Button alterar = layout.findViewById(R.id.alteracoesBtn);
        alterar.setOnClickListener(this);

       /*DataBase db = new DataBase(getActivity());
       db.PesuisarAll(1);
       db.PesuisarAll(2);*/
       //db.onCreate(db.getReadableDatabase());
        return layout;

   }

   //recebe string do TextView e pega dado e converte em String
    public static String nomeSt, sobrnomeSt, telefoneSt, idadeSt,
    valorSt,polSt, carSt, pontoSt;

    @Override
    public void onStart(){
        super.onStart();
        View v = getView();
        if(v != null){

            //= new TextView(getActivity());

            TextView nome = v.findViewById(R.id.nome);
            TextView sobrnome = v.findViewById(R.id.sobrnome);
            TextView telefone = v.findViewById(R.id.telefone);
            TextView idade = v.findViewById(R.id.idade);
            TextView valor = v.findViewById(R.id.valor);
            TextView poltrona = v.findViewById(R.id.poltrona);
            TextView carro = v.findViewById(R.id.carro);
            TextView ponto = v.findViewById(R.id.ponto);

            Button btn = v.findViewById(R.id.alteracoesBtn);

            //lugar é a string que tem a relação dos nomes
            //DadosPassageiros dados = DadosPassageiros.lugar[(int) wordId];

            //DataBase da= new DataBase(getActivity());

            DadosPassageiros dados = DadosPassageiros.lugar[(int) wordId];

            nome.setText(dados.getNome());
            sobrnome.setText(dados.getSobrnome());
            telefone.setText(dados.getTelefone());
            idade.setText(dados.getIdade());
            valor.setText(dados.getValor());
            poltrona.setText(dados.getAcento());
            ponto.setText(dados.getPonto());
            carro.setText(dados.getCarro());

            btn.setId(Integer.parseInt(dados.getAcento()));

            nomeSt = dados.getNome();
            sobrnomeSt = dados.getSobrnome();
            telefoneSt = dados.getTelefone();
            idadeSt = dados.getIdade();
            valorSt = dados.getValor();
            polSt = dados.getAcento();
            pontoSt = dados.getPonto();
            carSt = dados.getCarro();

            /*int id = (int) wordId;
            nome.setText(dados.PesquisarWord("nome",id,1).toString());
            sobrnome.setText(dados.PesquisarWord("sobrenome",v.getId(),1).toString());
            telefone.setText(dados.PesquisarWord("tel",v.getId(),1).toString());
            idade.setText(dados.PesquisarWord("idade",v.getId(),1).toString());
            valor.setText(dados.PesquisarWord("valor",v.getId(),1).toString());
            poltrona.setText(dados.PesquisarWord("poltrona",v.getId(),2).toString());
            ponto.setText(dados.PesquisarWord("ponto",v.getId(),2).toString());
            carro.setText(dados.PesquisarWord("carro",v.getId(),2).toString());

            btn.setId(Integer.parseInt(dados.PesquisarWord("poltrona",v.getId(),2).toString()));


            nomeSt = dados.PesquisarWord("nome",id,1).toString();
            sobrnomeSt = dados.PesquisarWord("sobrenome",v.getId(),1).toString();
            telefoneSt = dados.PesquisarWord("tel",v.getId(),1).toString();
            idadeSt = dados.PesquisarWord("idade",v.getId(),1).toString();
            valorSt = dados.PesquisarWord("valor",v.getId(),1).toString();
            polSt = dados.PesquisarWord("poltrona",v.getId(),2).toString();
            pontoSt = dados.PesquisarWord("ponto",v.getId(),2).toString();
            carSt = dados.PesquisarWord("carro",v.getId(),2).toString();
            */
            //id para passar dados
            final int idBtn = btn.getId();
            }else{
            TextView nome = v.findViewById(R.id.nome);
            nome.setText("anulada");
            }

    }
    @Override
    public void onClick(View v){
            onAlterar(v);
    }

    public void onAlterar(View v){

        Intent intent = new Intent(this.getActivity(), AlterarActivity.class);
        if(nomeSt.length() == 0){
            nomeSt = "vazio";
        }

        intent.putExtra("nome",nomeSt);
        intent.putExtra("sobrnome",sobrnomeSt);
        intent.putExtra("tel",telefoneSt);
        intent.putExtra("idade",idadeSt);
        intent.putExtra("valor",valorSt);
        intent.putExtra("ponto",pontoSt);
        intent.putExtra("acento",polSt);
        intent.putExtra("car",carSt);

       //Abrir activity_alterar.xml da class AlterarActivity
            startActivity(intent);


    }

    public void setWord(long id){
       this.wordId = id;
    }
}